package cn.chouyv.service.impl;

import cn.chouyv.common.response.ShopListInfoResponse;
import cn.chouyv.common.response.ShopListResponse;
import cn.chouyv.common.response.ShoppingInfoResponse;
import cn.chouyv.domain.Shop;
import cn.chouyv.exception.ShopInfoException;
import cn.chouyv.mapper.ShopMapper;
import cn.chouyv.service.ShopService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author SurKaa
 * @description 针对表【shop(商家表)】的数据库操作Service实现
 * @createDate 2023-08-08 15:42:54
 */
@Service
public class ShopServiceImpl extends ServiceImpl<ShopMapper, Shop>
        implements ShopService {

    @Override
    public Shop getShopInfoById(long id) {
        if (getBaseMapper().selectById(id) == null) {
            throw ShopInfoException.error("id错误");
        }
        return getBaseMapper().selectById(id);
    }

    @Override
    public ShopListResponse getAllShopsInfo(){
        ShopListResponse shopListResponse=ShopListResponse.toShopListResponse(getBaseMapper().getAllShopsInfo());
        return shopListResponse;
    }
}





