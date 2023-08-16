package cn.chouyv.service;

import cn.chouyv.common.request.AddBaseInfoRequest;
import cn.chouyv.common.request.StudentLoginRequest;

import cn.chouyv.common.request.StudentRegisterRequest;
import cn.chouyv.common.request.UpdateStudentBaseInfoRequest;
import cn.chouyv.common.response.AuthResponse;
import cn.chouyv.common.response.shop.StudentInfoResponse;
import cn.chouyv.domain.Student;
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
    AuthResponse registerStudent(StudentRegisterRequest registerRequest);

    /**
     * 学生登录
     *
     * @param loginRequest 登录请求体
     * @return 登录返回体
     */
    AuthResponse loginStudent(StudentLoginRequest loginRequest);

    StudentInfoResponse infoStudent(HttpServletRequest request);

    void AddStudentAddress (AddBaseInfoRequest addBaseInfoRequest,HttpServletRequest request);

    void UpdateStudentAddress(UpdateStudentBaseInfoRequest updateStudentBaseInfoRequest,HttpServletRequest request);

}
