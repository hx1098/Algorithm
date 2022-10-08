package T09_spring.T01_designPrinciple.T05_law_of_demeter_lob.V01;

import java.util.ArrayList;
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
public class Boss {

    public void checkNumOfCourse(TeamLeader teamLeader) {
        //模拟boss一页一页往下翻页，team leader实时统计
        List<Course> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add(new Course());
        }
        teamLeader.checkNumOfCourse(list);

    }



}
