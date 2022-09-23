package T09_spring.T01_designPrinciple.T03_simple_responsibility_principle;

/**
 * @author hx1098
 * @version 1.0.0
 * @createTime 2022/9/23 06:07
 * @description
 * @editUser hx1098
 * @editTime 2022/9/23 06:07
 * @editDescription 直播课 上面的V01 couse承担了两种逻辑处理，假设现在要进行加密，逻辑不一样，需要修改代码，我们对职责进行解耦
 */
public class Course_V02_LiveCouse {

    public void study(String courseName) {
        System.out.println(courseName + "不能快进");
    }

}