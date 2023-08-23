package cn.chouyv.service.impl;

import cn.chouyv.domain.ShoppingInfo;
import cn.chouyv.domain.Student;
import cn.chouyv.exception.ShopInfoException;
import cn.chouyv.mapper.ShoppingInfoMapper;
import cn.chouyv.mapper.StudentMapper;
import cn.chouyv.service.ShoppingInfoService;
import cn.chouyv.utils.SnowflakeUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author SurKaa
 * @description 针对表【shopping_info(用户的收货地址信息表)】的数据库操作Service实现
 * @createDate 2023-08-08 15:42:54
 */
@Service
public class ShoppingInfoServiceImpl extends ServiceImpl<ShoppingInfoMapper, ShoppingInfo>
        implements ShoppingInfoService {

    private final StudentMapper studentMapper;
    private final SnowflakeUtils snowflake;

    public ShoppingInfoServiceImpl(StudentMapper studentMapper, SnowflakeUtils snowflake) {
        this.studentMapper = studentMapper;
        this.snowflake = snowflake;
    }

    @Override
    public long addStudentShopInfo(ShoppingInfo shopInfoDTO, HttpServletRequest request) {
        Student student = studentMapper.checkLogin(request);
        long id = snowflake.newId();
        shopInfoDTO.setUid(student.getId());
        shopInfoDTO.setId(id);
        shopInfoDTO.setCreatedAt(null);
        shopInfoDTO.setUpdatedAt(null);
        shopInfoDTO.setIsDeleted(null);
        getBaseMapper().insert(shopInfoDTO);
        return id;
    }

    @Override
    public void deleteStudentShopInfo(Long id, HttpServletRequest request) {
        Student student = studentMapper.checkLogin(request);
        getBaseMapper().deleteById(id);
    }

    @Override
    public void updateStudentShopInfo(ShoppingInfo shopInfoDTO, HttpServletRequest request) {
        Student student = studentMapper.checkLogin(request);
        if (student == null) {
            throw ShopInfoException.errorWithNoLogin();
        }
        shopInfoDTO.setCreatedAt(null);
        shopInfoDTO.setUpdatedAt(null);
        shopInfoDTO.setIsDeleted(null);
        getBaseMapper().updateById(shopInfoDTO);
    }

    @Override
    public List<ShoppingInfo> getStudentShopInfo(HttpServletRequest request) {
        Student student = studentMapper.checkLogin(request);
        if (student == null) {
            throw ShopInfoException.errorWithNoLogin();
        }
        return getBaseMapper().selectAllByUid(student.getId());
    }

}




