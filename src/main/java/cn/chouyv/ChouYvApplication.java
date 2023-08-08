package cn.chouyv;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author SurKaa
 */
@SpringBootApplication
@MapperScan("cn.chouyv.mapper")
public class ChouYvApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChouYvApplication.class, args);
    }

}
