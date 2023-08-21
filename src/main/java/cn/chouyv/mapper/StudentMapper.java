package cn.chouyv.mapper;

import cn.chouyv.domain.Student;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

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

    @Deprecated
    Student selectOneByUsernameAndPassword(String username, String password);

    void addStudentAddress(long uid,String name,String location,String phone);
    void updateStudentAddress(long id,String name,String location,String phone);
}




