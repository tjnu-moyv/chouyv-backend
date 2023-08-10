package cn.chouyv.service.impl;

import cn.chouyv.domain.Shop;
import cn.chouyv.mapper.ShopMapper;
import cn.chouyv.service.ShopService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author SurKaa
 * @description 针对表【shop(商家表)】的数据库操作Service实现
 * @createDate 2023-08-08 15:42:54
 */
@Service
public class ShopServiceImpl extends ServiceImpl<ShopMapper, Shop>
        implements ShopService {

    @Override
    public Shop getShopInfoByid(Integer id) {
        return getBaseMapper().selectById(id);
    }
}





