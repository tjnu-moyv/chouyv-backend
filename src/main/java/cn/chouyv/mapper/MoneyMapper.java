package cn.chouyv.mapper;

import cn.chouyv.domain.Money;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * @author SurKaa
 * @description 针对表【money(用户钱包表)】的数据库操作Mapper
 * @createDate 2023-08-08 15:42:54
 * @Entity cn.chouyv.domain.Money
 */
public interface MoneyMapper extends BaseMapper<Money> {

    /**
     * 通过uid选择一个
     *
     * @param uid uid
     * @return {@link Money}
     */
    Money selectOneByUid(long uid);

}




