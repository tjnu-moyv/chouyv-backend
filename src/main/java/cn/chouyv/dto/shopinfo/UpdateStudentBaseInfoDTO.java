package cn.chouyv.dto.shopinfo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 更新学生基本信息请求
 * Created with IntelliJ IDEA.
 *
 * @author 17986
 * @Author: wang
 * @Date: 2023/08/16/11:05
 * @Description:
 * @date 2023/08/16
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateStudentBaseInfoDTO {
    /**
     * 此id为表id，非用户id
     */
    private Long id;
    private String name;
    private String location;
    private String phone;

}
