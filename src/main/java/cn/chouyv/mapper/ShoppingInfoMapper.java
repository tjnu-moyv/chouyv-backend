package cn.chouyv.mapper;

import cn.chouyv.domain.ShoppingInfo;
import cn.chouyv.dto.shoppinginfo.ShoppingInfoDTO;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author SurKaa
 * @description 针对表【shopping_info(用户的收货地址信息表)】的数据库操作Mapper
 * @createDate 2023-08-08 15:42:54
 * @Entity cn.chouyv.domain.ShoppingInfo
 */
@Mapper
public interface ShoppingInfoMapper extends BaseMapper<ShoppingInfo> {

    /**
     * 选择某学生的所有收货地址
     *
     * @param uid uid学生主键
     * @return {@link List}<{@link ShoppingInfo}>
     */
    default List<ShoppingInfo> selectAllByUid(long uid) {
        LambdaQueryWrapper<ShoppingInfo> lqw = new LambdaQueryWrapper<>();
        lqw.eq(ShoppingInfo::getUid, uid);
        return this.selectList(lqw);
    }

    /**
     * 删除id和学生对应的收货地址
     *
     * @param id  id
     * @param uid uid
     * @return int
     */
    default int deleteByIdAndStudentId(long id, long uid) {
        LambdaQueryWrapper<ShoppingInfo> lqw = new LambdaQueryWrapper<>();
        lqw.eq(ShoppingInfo::getId, id);
        lqw.eq(ShoppingInfo::getUid, uid);
        return this.delete(lqw);
    }

    default int updateByIdAndStudentId(ShoppingInfoDTO dto, long uid) {
        ShoppingInfo update = ShoppingInfo.builder()
                .name(dto.getName())
                .phone(dto.getPhone())
                .location(dto.getLocation())
                .build();
        LambdaQueryWrapper<ShoppingInfo> lqw = new LambdaQueryWrapper<>();
        lqw.eq(ShoppingInfo::getId, dto.getId());
        lqw.eq(ShoppingInfo::getUid, uid);
        return this.update(update, lqw);
    }

}




