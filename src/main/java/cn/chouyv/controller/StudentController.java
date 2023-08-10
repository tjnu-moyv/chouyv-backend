package cn.chouyv.controller;

import cn.chouyv.common.request.StudentLoginRequest;
import cn.chouyv.common.request.StudentRegisterRequest;
import cn.chouyv.common.response.AuthResponse;
import cn.chouyv.common.response.BaseResponse;
import cn.chouyv.service.StudentService;
import cn.chouyv.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @author SurKaa
 */
@Slf4j
@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/register")
    public BaseResponse<AuthResponse> register(
            @RequestBody StudentRegisterRequest registerRequest
    ) {
        log.info("Register: {}", registerRequest);
        AuthResponse response = studentService.registerStudent(registerRequest);
        return Result.success(response);
    }

    @PostMapping("/login")
    public BaseResponse<AuthResponse> login(
            @RequestBody StudentLoginRequest loginRequest
    ) {
        log.info("Login: {}", loginRequest);
        AuthResponse response = studentService.loginStudent(loginRequest);
        return Result.success(response);
    }
}
