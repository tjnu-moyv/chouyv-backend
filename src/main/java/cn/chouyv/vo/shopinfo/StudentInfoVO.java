package cn.chouyv.vo.shopinfo;

import cn.chouyv.domain.ShoppingInfo;
import cn.chouyv.domain.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 学生用户信息返回体
 *
 * @author SurKaa
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentInfoVO implements Serializable {

    private static final long serialVersionUID = -6666415261780399878L;

    private long id;
    private String username;
    private int role;
    private Date createdAt;
    private long shoppingInfoId;
    private List<ShoppingInfo> arrayOfShoppingInfo;

    public StudentInfoVO(Student student, List<ShoppingInfo> shoppingInfos) {
        this.id = student.getId();
        this.username = student.getUsername();
        this.role = student.getRole();
        this.createdAt = student.getCreatedAt();
        this.arrayOfShoppingInfo = shoppingInfos;
    }

}
