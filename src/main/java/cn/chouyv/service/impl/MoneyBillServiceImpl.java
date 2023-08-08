package cn.chouyv.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.chouyv.domain.MoneyBill;
import cn.chouyv.service.MoneyBillService;
import cn.chouyv.mapper.MoneyBillMapper;
import org.springframework.stereotype.Service;

/**
* @author SurKaa
* @description 针对表【money_bill(账单表)】的数据库操作Service实现
* @createDate 2023-08-08 15:42:54
*/
@Service
public class MoneyBillServiceImpl extends ServiceImpl<MoneyBillMapper, MoneyBill>
    implements MoneyBillService{

}




