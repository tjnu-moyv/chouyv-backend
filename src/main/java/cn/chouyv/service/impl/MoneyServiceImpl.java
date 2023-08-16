package cn.chouyv.service.impl;

import cn.chouyv.common.request.PayOrderRequest;
import cn.chouyv.common.response.PayOrderBillInfoResponse;
import cn.chouyv.domain.Money;
import cn.chouyv.domain.MoneyBill;
import cn.chouyv.domain.Order;
import cn.chouyv.domain.Student;
import cn.chouyv.exception.MoneyException;
import cn.chouyv.exception.TokenException;
import cn.chouyv.mapper.MoneyBillMapper;
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
    private final MoneyBillMapper moneyBillMapper;

    public MoneyServiceImpl(SnowflakeUtils snowflake, StudentMapper studentMapper, OrderMapper orderMapper, MoneyBillMapper moneyBillMapper) {
        this.snowflake = snowflake;
        this.studentMapper = studentMapper;
        this.orderMapper = orderMapper;
        this.moneyBillMapper = moneyBillMapper;
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
            String password = orderRequest.getPassword();
            if (password == null || password.length() < 6) {
                throw MoneyException.error("密码错误");
            }
            String codePwd = md5DigestAsHex(password);
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
            if (orderInfoById == null) {
                throw MoneyException.error("找不到与您对应的订单");
            }
            if (orderInfoById.getStatus() > Order.STATUS_WAIT_PAY) {
                throw MoneyException.error("您已支付");
            }
            if (orderInfoById.getStatus() == Order.STATUS_ERROR) {
                throw MoneyException.error("订单异常");
            }
            Integer totalPrice = orderInfoById.getTotalPrice();
            // 查询余额
            Money money = getBaseMapper().selectOneByUid(studentId);
            if (money.getCny() < totalPrice) {
                throw MoneyException.error("余额不足");
            }
            // 生成账单
            MoneyBill moneyBill = moneyBillMapper.transferToPublicAccount(
                    snowflake.newId(),
                    studentId,
                    0,
                    totalPrice
            );
            // 更新订单状态
            orderMapper.updateStatusById(orderInfoById.getId(), Order.STATUS_PAID);
            // 查询余额
            money = getBaseMapper().selectOneByUid(studentId);
            return new PayOrderBillInfoResponse(money.getCny(), moneyBill);
        } catch (ClassCastException e) {
            throw TokenException.error("token异常");
        }
    }
}




