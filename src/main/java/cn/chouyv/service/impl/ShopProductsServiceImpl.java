package cn.chouyv.service.impl;

import cn.chouyv.exception.ShopInfoException;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.chouyv.domain.ShopProducts;
import cn.chouyv.service.ShopProductsService;
import cn.chouyv.mapper.ShopProductsMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author SurKaa
 * @description 针对表【shop_products(商品信息表)】的数据库操作Service实现
 * @createDate 2023-08-08 15:42:54
 */
@Service
public class ShopProductsServiceImpl extends ServiceImpl<ShopProductsMapper, ShopProducts>
        implements ShopProductsService {

    @Override
    public List<ShopProducts> getShopProductsById(long id) {


        return getBaseMapper().selectAllByShopIdList(id);
    }
}




