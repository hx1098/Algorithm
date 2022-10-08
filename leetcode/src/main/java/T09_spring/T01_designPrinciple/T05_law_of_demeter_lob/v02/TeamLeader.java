package T09_spring.T01_designPrinciple.T05_law_of_demeter_lob.v02;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hx1098
 * @version 1.0.0
 * @createTime 2022/9/23 06:57
 * @description
 * @editUser hx1098
 * @editTime 2022/9/23 06:57
 * @editDescription 迪米特法则
 */
public class TeamLeader {

    public void checkNumOfCourse() {
        List<Course> courseList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            courseList.add(new Course());
        }
        System.out.println("目前已发布的课程数量是：" + courseList.size());

    }

}
