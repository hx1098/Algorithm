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
public class Boss {

    public void checkNumOfCourse(TeamLeader teamLeader) {
        teamLeader.checkNumOfCourse();
    }



}
