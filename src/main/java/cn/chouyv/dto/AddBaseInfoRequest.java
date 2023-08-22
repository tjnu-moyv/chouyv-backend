package cn.chouyv.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: wang
 * @Date: 2023/08/16/10:25
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddBaseInfoRequest {
    private String name;
    private String location;
    private String phone;
}
