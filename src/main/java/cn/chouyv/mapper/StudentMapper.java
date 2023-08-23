package cn.chouyv.mapper;

import cn.chouyv.domain.Student;
import cn.chouyv.exception.TokenException;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import javax.servlet.http.HttpServletRequest;

/**
 * @author SurKaa
 * @description 针对表【student(用户信息表)】的数据库操作Mapper
 * @createDate 2023-08-08 15:42:54
 * @Entity cn.chouyv.domain.Student
 */
@Mapper
public interface StudentMapper extends BaseMapper<Student> {

    /**
     * 通过用户名获取学生
     *
     * @param username 用户名
     * @return 学生
     */
    Student selectOneByUsername(String username);

    /**
     * 通过id获取学生
     *
     * @param id 学生id(long)
     * @return 学生
     */
    Student selectOneById(long id);

    /**
     * 通过id和用户选择一个学生
     *
     * @param id       id
     * @param username 用户名
     * @return {@link Student}
     */
    Student selectOneByIdAndUsernameStudent(long id, String username);

    @Deprecated
    Student selectOneByUsernameAndPassword(String username, String password);

    /**
     * 检查token是否合法
     *
     * @param request 请求
     * @return {@link Student}
     */
    default Student checkLogin(HttpServletRequest request) throws TokenException {
        Long id;
        String username;
        try {
            id = (Long) request.getAttribute("id");
            username = (String) request.getAttribute("username");
            if (username == null || username.length() == 0 || id == null) {
                throw TokenException.errorToken();
            }
        } catch (ClassCastException e) {
            throw TokenException.errorToken();
        }
        Student student = selectOneByIdAndUsernameStudent(id, username);
        if (student == null) {
            throw TokenException.errorToken();
        }
        return student;
    }
}
