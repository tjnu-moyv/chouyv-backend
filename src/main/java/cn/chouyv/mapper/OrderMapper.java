package cn.chouyv.mapper;

import cn.chouyv.domain.Order;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author SurKaa
 * @description 针对表【order(订单表)】的数据库操作Mapper
 * @createDate 2023-08-08 15:42:54
 * @Entity cn.chouyv.domain.Order
 */
@Mapper
public interface OrderMapper extends BaseMapper<Order> {
    /**
     * 通过id获取订单信息
     * 不包含产品
     *
     * @param id        id
     * @param studentId 学生主键
     * @return {@link Order}
     */

    Order getOrderInfoById(long id, long studentId);

    /**
     * 通过id更新订单状态
     *
     * @param id     id
     * @param status 状态
     */
    void updateStatusById(long id, int status);

}




