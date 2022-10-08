package T09_spring.T01_designPrinciple.T05_law_of_demeter_lob.v02;

/**
 * @author hx1098
 * @version 1.0.0
 * @createTime 2022/9/23 07:02
 * @description
 * @editUser hx1098
 * @editTime 2022/9/23 07:02
 * @editDescription 迪米特法则
 */
public class main {

    public static void main(String[] args) {
        Boss boss = new Boss();
        TeamLeader teamLeader = new TeamLeader();
        boss.checkNumOfCourse(teamLeader);

    }

}
