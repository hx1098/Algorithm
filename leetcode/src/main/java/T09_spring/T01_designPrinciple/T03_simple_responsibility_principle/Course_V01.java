package T09_spring.T01_designPrinciple.T03_simple_responsibility_principle;

/**
 * @author hx1098
 * @version 1.0.0
 * @createTime 2022/9/23 06:07
 * @description
 * @editUser hx1098
 * @editTime 2022/9/23 06:07
 * @editDescription
 */
public class Course_V01 {

    public void study(String courseName) {
        if ("直播课".equals(courseName)) {
            System.out.println(courseName + "不能快进");
        } else {
            System.out.println(courseName + "可以反复会看");
        }
    }

}