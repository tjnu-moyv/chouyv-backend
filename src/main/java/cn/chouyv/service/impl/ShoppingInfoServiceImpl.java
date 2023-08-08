package cn.chouyv.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.chouyv.domain.ShoppingInfo;
import cn.chouyv.service.ShoppingInfoService;
import cn.chouyv.mapper.ShoppingInfoMapper;
import org.springframework.stereotype.Service;

/**
* @author SurKaa
* @description 针对表【shopping_info(用户的收货地址信息表)】的数据库操作Service实现
* @createDate 2023-08-08 15:42:54
*/
@Service
public class ShoppingInfoServiceImpl extends ServiceImpl<ShoppingInfoMapper, ShoppingInfo>
    implements ShoppingInfoService{

}




