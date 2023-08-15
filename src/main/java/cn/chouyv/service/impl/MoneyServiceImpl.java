package cn.chouyv.service.impl;

import cn.chouyv.domain.Money;
import cn.chouyv.exception.MoneyException;
import cn.chouyv.mapper.MoneyMapper;
import cn.chouyv.service.MoneyService;
import cn.chouyv.utils.SnowflakeUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author SurKaa
 * @description 针对表【money(用户钱包表)】的数据库操作Service实现
 * @createDate 2023-08-08 15:42:54
 */
@Service
public class MoneyServiceImpl extends ServiceImpl<MoneyMapper, Money>
        implements MoneyService {

    private final SnowflakeUtils snowflake;

    public MoneyServiceImpl(SnowflakeUtils snowflake) {
        this.snowflake = snowflake;
    }

    @Override
    public Money createMoney(long uid) {
        Money money = new Money();
        money.setUid(uid);
        money.setId(snowflake.newId());
        boolean flag = this.save(money);
        if (!flag) {
            throw MoneyException.error("账户创建失败");
        }
        return money;
    }

    @Override
    public Money getMoney(long uid) {
        return this.getBaseMapper().selectOneByUid(uid);
    }
}




