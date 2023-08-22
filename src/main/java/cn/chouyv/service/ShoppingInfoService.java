package cn.chouyv.service;

import cn.chouyv.domain.ShoppingInfo;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author SurKaa
 * @description 针对表【shopping_info(用户的收货地址信息表)】的数据库操作Service
 * @createDate 2023-08-08 15:42:54
 */
public interface ShoppingInfoService extends IService<ShoppingInfo> {

    long addStudentShopInfo(ShoppingInfo shopInfoDTO, HttpServletRequest request);

    void deleteStudentShopInfo(Long id, HttpServletRequest request);

    void updateStudentShopInfo(ShoppingInfo shoppingInfoDTO, HttpServletRequest request);

    List<ShoppingInfo> getStudentShopInfo(HttpServletRequest request);
}
