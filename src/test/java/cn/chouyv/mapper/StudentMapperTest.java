package cn.chouyv.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StudentMapperTest {

    @Autowired
    private StudentMapper mapper;

    @Test
    public void selectOneByUsername() {
        System.out.println("mapper.selectOneByUsername(\"RiWWcBqhyA\") = " + mapper.selectOneByUsername("RiWWcBqhyA"));
    }

    @Test
    void selectOneById() {

    }

    @Test
    void selectOneByUsernameAndPassword() {
        try {
            System.out.println("mapper.selectOneByUsernameAndPassword(\"'YuqsYU' --\", \"1\") = "
                    + mapper.selectOneByUsernameAndPassword("'YuqsYU' --", "1"));
        } catch (Exception e) {
            System.err.println("mapper.selectOneByUsernameAndPassword(\"'YuqsYU' --\", \"1\") = " + e.getMessage());
        }
    }

    @Test
    void addStudentAddress() {

    }

    @Test
    void updateStudentAddress() {

    }
}
