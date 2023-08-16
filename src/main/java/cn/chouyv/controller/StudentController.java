package cn.chouyv.controller;

import cn.chouyv.common.request.AddBaseInfoRequest;
import cn.chouyv.common.request.StudentLoginRequest;
import cn.chouyv.common.request.StudentRegisterRequest;
import cn.chouyv.common.request.SubmitBookRequest;
import cn.chouyv.common.response.AuthResponse;
import cn.chouyv.common.response.BaseResponse;
import cn.chouyv.common.response.shop.StudentInfoResponse;
import cn.chouyv.common.response.shop.SubmitBookResponse;
import cn.chouyv.service.ShopService;
import cn.chouyv.service.StudentService;
import cn.chouyv.utils.Result;
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
    public BaseResponse<String> addStudentAddress(@RequestBody AddBaseInfoRequest addBaseInfoRequest,HttpServletRequest request){
        log.info("Info: {}", request);
        studentService.AddStudentAddress(addBaseInfoRequest,request);
        return Result.success(null);
    }

}
