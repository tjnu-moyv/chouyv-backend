package cn.chouyv.service.impl;

import cn.chouyv.common.request.StudentLoginRequest;
import cn.chouyv.common.request.StudentRegisterRequest;
import cn.chouyv.common.response.AuthResponse;
import cn.chouyv.common.response.StudentInfoResponse;
import cn.chouyv.domain.ShoppingInfo;
import cn.chouyv.domain.Student;
import cn.chouyv.exception.LoginException;
import cn.chouyv.exception.RegisterException;
import cn.chouyv.exception.TokenException;
import cn.chouyv.mapper.ShoppingInfoMapper;
import cn.chouyv.mapper.StudentMapper;
import cn.chouyv.service.StudentService;
import cn.chouyv.utils.JwtHandle;
import cn.chouyv.utils.SnowflakeUtils;
import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTPayload;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Objects;

/**
 * @author SurKaa
 * @description 针对表【student(用户信息表)】的数据库操作Service实现
 * @createDate 2023-08-08 15:42:54
 */
@Slf4j
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student>
        implements StudentService {

    private final ShoppingInfoMapper shoppingInfoMapper;
    private final JwtHandle jwtHandle;
    private final SnowflakeUtils snowflake;

    public StudentServiceImpl(
            ShoppingInfoMapper shoppingInfoMapper,
            JwtHandle jwtHandle,
            SnowflakeUtils snowflake
    ) {
        this.shoppingInfoMapper = shoppingInfoMapper;
        this.jwtHandle = jwtHandle;
        this.snowflake = snowflake;
    }

    @Override
    public AuthResponse registerStudent(StudentRegisterRequest registerRequest) {
        if (null == registerRequest) {
            throw RegisterException.error("请求体为空");
        }

        String username = registerRequest.getUsername();
        String password = registerRequest.getPassword();
        String checkPwd = registerRequest.getCheckPwd();

        if (null == username || username.length() < 6) {
            throw RegisterException.error("账号长度不能小于6位");
        }

        log.debug("注册用户名: username={}", username);

        if (null == password || password.length() < 6) {
            throw RegisterException.error("密码长度不能小于6位");
        }

        if (null == checkPwd || checkPwd.length() < 6) {
            throw RegisterException.error("确认密码长度不能小于6位");
        }

        if (!password.equals(checkPwd)) {
            throw RegisterException.error("两次密码不一致");
        }

        if (checkCharInAuthString(username)) {
            throw RegisterException.error("账号不能包含特殊字符");
        }

        if (checkCharInAuthString(password)) {
            throw RegisterException.error("密码不能包含特殊字符");
        }

        Student byUsername = getBaseMapper().selectOneByUsername(username);

        if (null != byUsername) {
            throw RegisterException.error("账号已存在");
        }

        String pwd = md5DigestAsHex(password);
        long id = snowflake.newStudentId();
        Student student = new Student(id, username, pwd);
        log.debug("即将保存学生信息: {}", student);
        boolean flag = this.save(student);
        if (!flag) {
            // 注册失败
            throw RegisterException.error("注册失败");
        }
        String token = jwtHandle.generateToken(id, username);
        log.debug("注册成功 token: {}", token);
        return new AuthResponse(id, username, token);
    }

    @Override
    public AuthResponse loginStudent(StudentLoginRequest loginRequest) {
        if (null == loginRequest) {
            throw LoginException.error("请求体为空");
        }

        String username = loginRequest.getUsername();
        String inputPwd = loginRequest.getPassword();

        if (null == username || username.length() < 6) {
            throw LoginException.error("账号长度不能小于6位");
        }

        log.debug("登录用户名: username={}", username);

        if (null == inputPwd || inputPwd.length() < 6) {
            throw LoginException.error("密码长度不能小于6位");
        }

        if (checkCharInAuthString(username)) {
            throw LoginException.error("账号不能包含特殊字符");
        }

        if (checkCharInAuthString(inputPwd)) {
            throw LoginException.error("密码不能包含特殊字符");
        }

        log.debug("开始检查是否存在该用户");
        Student byUsername = getBaseMapper().selectOneByUsername(username);

        if (null == byUsername) {
            throw LoginException.error("没有找到这个用户");
        }

        String input = md5DigestAsHex(inputPwd);
        if (!Objects.equals(input, byUsername.getPassword())) {
            throw LoginException.error("用户名或密码错误");
        }

        Student safe = Student.safe(byUsername);
        String token = jwtHandle.generateToken(
                safe.getId(), safe.getUsername());
        log.debug("登录成功 token: {}", token);
        return new AuthResponse(safe.getId(), safe.getUsername(), token);
    }

    @Override
    public StudentInfoResponse infoStudent(HttpServletRequest request) {
        String token = request.getHeader("token");
        log.debug("info token: {}", token);
        JWT jwt = jwtHandle.validate(token);
        try {
            String idStr = (String) jwt.getPayload(JWTPayload.ISSUER);
            long id = Long.parseLong(idStr);
            log.debug("idStr: {}", id);
            Student byId = getBaseMapper().selectOneById(id);
            if (null == byId) {
                throw TokenException.error("异常token");
            }
            log.debug("byId: {}", byId);
            String username = (String) jwt.getPayload(JWTPayload.SUBJECT);
            log.debug("username: {}", username);
            if (!Objects.equals(username, byId.getUsername())) {
                throw TokenException.error("异常token");
            }

            log.debug("开始获取收货地址信息");
            List<ShoppingInfo> shoppingInfos
                    = shoppingInfoMapper.selectAllByUid(id);

            return new StudentInfoResponse(byId, shoppingInfos);
        } catch (ClassCastException e) {
            // String idObj = `(String)` jwt.getPayload(JWTPayload.ISSUER);
            throw TokenException.error("非法token");
        } catch (NumberFormatException e) {
            // long id = Long.`parseLong`(idObj);
            throw TokenException.error("异常token");
        }
    }

    private static boolean checkCharInAuthString(String authString) {
        // 分别包括:
        // a-z, A-Z
        // 0-9
        return !authString.matches("^[a-zA-Z0-9!-.:-@]+$");
    }

    /**
     * 获取加密后的密码
     *
     * @param password 密码明文
     * @return 密码密文
     */
    private static String md5DigestAsHex(String password) {
        return DigestUtils.md5DigestAsHex(password.getBytes());
    }
}




