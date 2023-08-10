package cn.chouyv.controller;

import cn.chouyv.common.BaseResponse;
import cn.chouyv.service.StudentService;
import cn.chouyv.utils.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author SurKaa
 */
@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public BaseResponse<Integer> test() {
        return Result.success(1);
    }
}
