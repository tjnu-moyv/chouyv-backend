package cn.chouyv.mapper;

import cn.chouyv.domain.MoneyBill;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author SurKaa
 * @description 针对表【money_bill(账单表)】的数据库操作Mapper
 * @createDate 2023-08-08 15:42:54
 * @Entity cn.chouyv.domain.MoneyBill
 */
@Mapper
public interface MoneyBillMapper extends BaseMapper<MoneyBill> {

    /**
     * 转账
     *
     * @param id     id
     * @param fromId 转入账户id
     * @param toId   转出账户id
     * @param type   转账类型
     * @param money  金额
     * @return {@link MoneyBill}
     */
    @Select("CALL InsertBillAndUpdateMoneyAndReturnDataSP(#{id}, #{fromId}, #{toId}, #{type}, #{money})")
    MoneyBill transfer(long id, long fromId, long toId, int type, int money);

    /**
     * 转账到公共账户
     *
     * @param id     id
     * @param fromId 转入账户id
     * @param type   转账类型
     * @param money  金额
     * @return {@link MoneyBill}
     */
    default MoneyBill transferToPublicAccount(long id, long fromId, int type, int money) {
        // TODO  return transfer(id, fromId, properties.getPublicAccountId(), type, money);
        return transfer(id, fromId, 0, type, money);
    }

    /**
     * 从公共账户转账
     *
     * @param id    id
     * @param toId  转出账户id
     * @param type  转账类型
     * @param money 金额
     * @return {@link MoneyBill}
     */
    default MoneyBill transferFromPublicAccount(long id, long toId, int type, int money) {
        // TODO return transfer(id, properties.getPublicAccountId(), toId, type, money);
        return transfer(id, 0, toId, type, money);
    }

}




