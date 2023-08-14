package cn.chouyv.service;

import cn.chouyv.domain.Money;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author SurKaa
 * @description 针对表【money(用户钱包表)】的数据库操作Service
 * @createDate 2023-08-08 15:42:54
 */
public interface MoneyService extends IService<Money> {

    /**
     * 给用户开户
     *
     * @param uid 开户id
     * @return 开户信息
     */
    Money createMoney(long uid);

}
