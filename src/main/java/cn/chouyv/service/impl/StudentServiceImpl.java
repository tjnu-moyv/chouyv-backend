package cn.chouyv.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.chouyv.domain.Student;
import cn.chouyv.service.StudentService;
import cn.chouyv.mapper.StudentMapper;
import org.springframework.stereotype.Service;

/**
* @author SurKaa
* @description 针对表【student(用户信息表)】的数据库操作Service实现
* @createDate 2023-08-08 15:42:54
*/
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student>
    implements StudentService{

}




