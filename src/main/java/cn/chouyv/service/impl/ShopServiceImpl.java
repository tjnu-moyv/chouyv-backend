package cn.chouyv.service.impl;

import cn.chouyv.common.request.SubmitBookRequest;
import cn.chouyv.common.response.shop.ShopListResponse;
import cn.chouyv.common.response.shop.SubmitBookResponse;
import cn.chouyv.domain.Shop;
import cn.chouyv.exception.ProductCountError;
import cn.chouyv.exception.ShopInfoException;
import cn.chouyv.mapper.ShopMapper;
import cn.chouyv.service.ShopService;
import cn.chouyv.utils.SnowflakeUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * @author SurKaa
 * @description 针对表【shop(商家表)】的数据库操作Service实现
 * @createDate 2023-08-08 15:42:54
 */
@Service
public class ShopServiceImpl extends ServiceImpl<ShopMapper, Shop>
        implements ShopService {

    private final SnowflakeUtils snowflake;

    public ShopServiceImpl(SnowflakeUtils snowflake) {
        this.snowflake = snowflake;
    }

    @Override
    public Shop getShopInfoById(long id) {
        if (getBaseMapper().selectById(id) == null) {
            throw ShopInfoException.error("id错误");
        }
        return getBaseMapper().selectById(id);
    }

    @Override
    public ShopListResponse getAllShopsInfo() {
        ShopListResponse shopListResponse = ShopListResponse.toShopListResponse(getBaseMapper().getAllShopsInfo());
        return shopListResponse;
    }

    @Override
    public SubmitBookResponse produceBook(SubmitBookRequest submitBookRequest, HttpServletRequest request) {
        long tokenId = Long.parseLong((String) request.getAttribute("id"));

        long l = snowflake.newId();
        long sumMoney=0;
        for (int i = 0; i < submitBookRequest.products.size(); i++) {
            if(submitBookRequest.products.get(i).count<0){
                throw ProductCountError.error("数量不能为负");
            }else if(submitBookRequest.products.get(i).price<0){
                throw  ProductCountError.error("金额不能为负");
            }

            sumMoney += submitBookRequest.products.get(i).count * submitBookRequest.products.get(i).price;
        }

         this.getBaseMapper().produceBook(l,tokenId, sumMoney, submitBookRequest.getShopId(), submitBookRequest.getType());
        return new SubmitBookResponse(l,sumMoney);
    }


}





