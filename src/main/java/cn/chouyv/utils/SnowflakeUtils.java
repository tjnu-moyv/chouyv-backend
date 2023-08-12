package cn.chouyv.utils;

import cn.chouyv.config.ChouYvProperties;
import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import org.springframework.stereotype.Component;

/**
 * 雪花算法生成id
 *
 * @author SurKaa
 */
@Component
public class SnowflakeUtils {

    private final ChouYvProperties properties;

    private volatile Snowflake snowflakeOfStudent;
    private volatile Snowflake snowflakeOfShop;

    public SnowflakeUtils(ChouYvProperties properties) {
        this.properties = properties;
    }

    /**
     * 雪花算法分布式生成唯一id
     *
     * @return 学生id
     */
    public long newStudentId() {
        if (snowflakeOfStudent == null) {
            synchronized (SnowflakeUtils.class) {
                if (snowflakeOfStudent == null) {
                    snowflakeOfStudent = IdUtil.getSnowflake(
                            properties.getMachineId(),
                            1
                    );
                }
            }
        }
        return snowflakeOfStudent.nextId();
    }

    /**
     * 雪花算法分布式生成唯一id
     *
     * @return 教师id
     */
    public long newShopId() {
        if (snowflakeOfShop == null) {
            synchronized (SnowflakeUtils.class) {
                if (snowflakeOfShop == null) {
                    snowflakeOfShop = IdUtil.getSnowflake(
                            properties.getMachineId(),
                            2
                    );
                }
            }
        }
        return snowflakeOfShop.nextId();
    }

}
