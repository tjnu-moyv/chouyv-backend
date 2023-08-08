package cn.chouyv.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.chouyv.domain.Money;
import cn.chouyv.service.MoneyService;
import cn.chouyv.mapper.MoneyMapper;
import org.springframework.stereotype.Service;

/**
* @author SurKaa
* @description 针对表【money(用户钱包表)】的数据库操作Service实现
* @createDate 2023-08-08 15:42:54
*/
@Service
public class MoneyServiceImpl extends ServiceImpl<MoneyMapper, Money>
    implements MoneyService{

}




