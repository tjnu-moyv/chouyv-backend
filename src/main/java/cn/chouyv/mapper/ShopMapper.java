package cn.chouyv.mapper;

import cn.chouyv.domain.Shop;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author SurKaa
 * @description 针对表【shop(商家表)】的数据库操作Mapper
 * @createDate 2023-08-08 15:42:54
 * @Entity cn.chouyv.domain.Shop
 */
@Mapper
public interface ShopMapper extends BaseMapper<Shop> {

    /**
     * 选择一个shop通过id
     *
     * @param id id
     * @return {@link Shop}
     */
    Shop selectOneByIdShop(long id);

}




