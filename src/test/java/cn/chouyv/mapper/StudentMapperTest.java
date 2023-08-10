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

}
