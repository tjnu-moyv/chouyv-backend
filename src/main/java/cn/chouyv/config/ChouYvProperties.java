package cn.chouyv.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 项目中的自定义配置
 *
 * @author SurKaa
 */
@Slf4j
@Component
@ConfigurationProperties(prefix = "cn.chouyv")
public class ChouYvProperties {

    /**
     * jwt密钥
     */
    private String jwtSecretKey = "key";

    /**
     * 机器id
     */
    private int machineId = 0;
    private static volatile byte[] key = null;

    public byte[] getJwtSecretKey() {
        if (key == null) {
            synchronized (ChouYvProperties.class) {
                if (key == null) {
                    key = jwtSecretKey.getBytes();
                }
            }
        }
        return key;
    }

    public int getMachineId() {
        return machineId;
    }

    public void setJwtSecretKey(String jwtSecretKey) {
        this.jwtSecretKey = jwtSecretKey;
    }

    public void setMachineId(int machineId) {
        this.machineId = machineId;
    }
}
