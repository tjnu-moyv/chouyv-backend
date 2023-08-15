package cn.chouyv.service.impl;

import cn.chouyv.common.request.PayOrderRequest;
import cn.chouyv.common.response.PayOrderBillInfoResponse;
import cn.chouyv.domain.Money;
import cn.chouyv.domain.MoneyBill;
import cn.chouyv.domain.Order;
import cn.chouyv.domain.Student;
import cn.chouyv.exception.MoneyException;
import cn.chouyv.mapper.MoneyMapper;
import cn.chouyv.mapper.OrderMapper;
import cn.chouyv.mapper.StudentMapper;
import cn.chouyv.service.MoneyService;
import cn.chouyv.utils.SnowflakeUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

import java.util.Objects;

import static cn.chouyv.utils.Pwd.md5DigestAsHex;

/**
 * @author SurKaa
 * @description 针对表【money(用户钱包表)】的数据库操作Service实现
 * @createDate 2023-08-08 15:42:54
 */
@Service
public class MoneyServiceImpl extends ServiceImpl<MoneyMapper, Money>
        implements MoneyService {

    private final SnowflakeUtils snowflake;
    private final StudentMapper studentMapper;
    private final OrderMapper orderMapper;

    public MoneyServiceImpl(SnowflakeUtils snowflake, StudentMapper studentMapper, OrderMapper orderMapper) {
        this.snowflake = snowflake;
        this.studentMapper = studentMapper;
        this.orderMapper = orderMapper;
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

    @Override
    public PayOrderBillInfoResponse payOrder(
            PayOrderRequest orderRequest, HttpServletRequest request
    ) {
        try {
            // 解析信息
            long studentId = Long.parseLong((String) request.getAttribute("id"));
            String username = (String) request.getAttribute("username");
            String codePwd = md5DigestAsHex(orderRequest.getPassword());
            // 查询
            Student byUsername = studentMapper.selectOneByUsername(username);
            if (byUsername == null) {
                throw MoneyException.error("请使用自己的账号支付");
            }
            if (!Objects.equals(studentId, byUsername.getId())) {
                throw MoneyException.error("token异常 请刷新重试");
            }
            if (!Objects.equals(codePwd, byUsername.getPassword())) {
                throw MoneyException.error("支付密码错误");
            }
            // 查询订单获取总价
            Order orderInfoById = orderMapper.getOrderInfoById(orderRequest.getOrderId(), studentId);
            Integer totalPrice = orderInfoById.getTotalPrice();
            // 查询余额
            Money money = getBaseMapper().selectOneByUid(studentId);
            if (money.getCny() < totalPrice) {
                throw MoneyException.error("余额不足");
            }
            MoneyBill moneyBill = new MoneyBill();
            // TODO
            return null;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}




