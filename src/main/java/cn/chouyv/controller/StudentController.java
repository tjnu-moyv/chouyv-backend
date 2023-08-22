package cn.chouyv.controller;

import cn.chouyv.dto.*;
import cn.chouyv.service.ShopService;
import cn.chouyv.service.StudentService;
import cn.chouyv.utils.Result;
import cn.chouyv.vo.AuthResponse;
import cn.chouyv.vo.BaseResponse;
import cn.chouyv.vo.shop.StudentInfoResponse;
import cn.chouyv.vo.shop.SubmitBookResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author SurKaa
 */
@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;
    private final ShopService shopService;

    public StudentController(StudentService studentService, ShopService shopService) {
        this.studentService = studentService;
        this.shopService = shopService;
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

    @GetMapping
    public BaseResponse<StudentInfoResponse> info(
            HttpServletRequest request
    ) {
        log.info("Info: {}", request);
        StudentInfoResponse response = studentService.infoStudent(request);
        return Result.success(response);
    }

    @PostMapping("/order")
    public BaseResponse<SubmitBookResponse> submitBookResponseBaseResponse(
            @RequestBody SubmitBookRequest submitBookRequest,
            HttpServletRequest request
    ) {
        log.info("Info: {}", request);
        SubmitBookResponse submitBookResponse = shopService.produceBook(submitBookRequest, request);
        return Result.success(submitBookResponse);
    }

    @PostMapping("addinfo")
    public BaseResponse<String> addStudentAddress(@RequestBody AddBaseInfoRequest addBaseInfoRequest, HttpServletRequest request) {
        log.info("Info: {}", request);
        studentService.AddStudentAddress(addBaseInfoRequest, request);
        return Result.success(null);
    }

    @PutMapping("addinfo")
    public BaseResponse<String> updateStudentInfo(@RequestBody UpdateStudentBaseInfoRequest updateStudentBaseInfoRequest, HttpServletRequest request) {
        log.info("Info: {}", request);
        studentService.UpdateStudentAddress(updateStudentBaseInfoRequest, request);
        return Result.success(null);
    }

}
