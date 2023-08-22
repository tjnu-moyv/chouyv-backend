package cn.chouyv.controller;

import cn.chouyv.dto.pay.SubmitBookDTO;
import cn.chouyv.dto.student.StudentLoginDTO;
import cn.chouyv.dto.student.StudentRegisterDTO;
import cn.chouyv.service.ShopService;
import cn.chouyv.service.StudentService;
import cn.chouyv.utils.Result;
import cn.chouyv.vo.AuthVO;
import cn.chouyv.vo.BaseVO;
import cn.chouyv.vo.pay.SubmitBookVO;
import cn.chouyv.vo.shopinfo.StudentInfoVO;
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
    public BaseVO<AuthVO> register(
            @RequestBody StudentRegisterDTO registerRequest
    ) {
        log.info("Register: {}", registerRequest);
        AuthVO response = studentService.registerStudent(registerRequest);
        return Result.success(response);
    }

    @PostMapping("/login")
    public BaseVO<AuthVO> login(
            @RequestBody StudentLoginDTO loginRequest
    ) {
        log.info("Login: {}", loginRequest);
        AuthVO response = studentService.loginStudent(loginRequest);
        return Result.success(response);
    }

    @GetMapping
    public BaseVO<StudentInfoVO> info(
            HttpServletRequest request
    ) {
        log.info("Info: {}", request);
        StudentInfoVO response = studentService.infoStudent(request);
        return Result.success(response);
    }

    @PostMapping("/order")
    public BaseVO<SubmitBookVO> submitBookResponseBaseResponse(
            @RequestBody SubmitBookDTO submitBookDTO,
            HttpServletRequest request
    ) {
        log.info("Info: {}", request);
        SubmitBookVO submitBookVO = shopService.produceBook(submitBookDTO, request);
        return Result.success(submitBookVO);
    }

}
