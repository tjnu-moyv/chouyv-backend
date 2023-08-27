package cn.chouyv.mapper;

import cn.chouyv.dto.shoppinginfo.ShoppingInfoDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ShoppingInfoMapperTest {

    @Autowired
    private ShoppingInfoMapper shoppingInfoMapper;

    @Test
    void selectAllByUid() {
        System.out.println("shoppingInfoMapper.selectAllByUid(2) = " + shoppingInfoMapper.selectAllByUid(2));
    }

    @Test
    void updateByIdAndStudentId() {
        System.out.println("shoppingInfoMapper.updateByIdAndStudentId(new ShoppingInfoDTO(35, \"aaa\", \"test\", \"test\"), 838) = " + shoppingInfoMapper.updateByIdAndStudentId(new ShoppingInfoDTO(35, "aaa", "test", "test"), 838));
        System.out.println("shoppingInfoMapper.selectById(35) = " + shoppingInfoMapper.selectById(35));
    }

    @Test
    void deleteByIdAndStudentId() {
        System.out.println("shoppingInfoMapper.deleteByIdAndStudentId(35, 838) = " + shoppingInfoMapper.deleteByIdAndStudentId(35, 838));
        System.out.println("shoppingInfoMapper.selectById(35) = " + shoppingInfoMapper.selectById(35));
    }
}