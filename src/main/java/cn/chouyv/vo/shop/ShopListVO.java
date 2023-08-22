package cn.chouyv.vo.shop;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: wang
 * @Date: 2023/08/11/11:06
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShopListVO {
    public List<ShopListInfoVO> shops;
}


