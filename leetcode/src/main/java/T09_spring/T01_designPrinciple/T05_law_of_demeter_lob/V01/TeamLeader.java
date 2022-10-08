package T09_spring.T01_designPrinciple.T05_law_of_demeter_lob.V01;

import java.util.List;

/**
 * @author hx1098
 * @version 1.0.0
 * @createTime 2022/9/23 06:57
 * @description
 * @editUser hx1098
 * @editTime 2022/9/23 06:57
 * @editDescription
 */
public class TeamLeader {

    public void checkNumOfCourse(List<Course> courseList) {
        System.out.println("当前已经发布的课程数量是：" + courseList.size());
    }

}
