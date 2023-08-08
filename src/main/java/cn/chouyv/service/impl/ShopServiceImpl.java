package cn.chouyv.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.chouyv.domain.Shop;
import cn.chouyv.service.ShopService;
import cn.chouyv.mapper.ShopMapper;
import org.springframework.stereotype.Service;

/**
* @author SurKaa
* @description 针对表【shop(商家表)】的数据库操作Service实现
* @createDate 2023-08-08 15:42:54
*/
@Service
public class ShopServiceImpl extends ServiceImpl<ShopMapper, Shop>
    implements ShopService{

}




