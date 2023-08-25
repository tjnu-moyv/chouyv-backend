package cn.chouyv.service;

import cn.chouyv.domain.Student;
import cn.chouyv.dto.student.StudentLoginDTO;
import cn.chouyv.dto.student.StudentRegisterDTO;
import cn.chouyv.vo.AuthVO;
import cn.chouyv.vo.shopinfo.StudentInfoVO;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.servlet.http.HttpServletRequest;

/**
 * @author SurKaa
 * @description 针对表【student(用户信息表)】的数据库操作Service
 * @createDate 2023-08-08 15:42:54
 */
public interface StudentService extends IService<Student> {

    /**
     * 学生注册
     *
     * @param registerRequest 注册请求体
     * @return 注册返回体
     */
    AuthVO registerStudent(StudentRegisterDTO registerRequest);

    /**
     * 学生登录
     *
     * @param loginRequest 登录请求体
     * @return 登录返回体
     */
    AuthVO loginStudent(StudentLoginDTO loginRequest);

<<<<<<< Updated upstream
    StudentInfoVO infoStudent(HttpServletRequest request);
=======
    void deleteStudentAddress(long id,HttpServletRequest request);
>>>>>>> Stashed changes
}
