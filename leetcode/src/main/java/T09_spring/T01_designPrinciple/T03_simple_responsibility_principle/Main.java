package T09_spring.T01_designPrinciple.T03_simple_responsibility_principle;

/**
 * @author hx1098
 * @version 1.0.0
 * @createTime 2022/9/23 06:11
 * @description
 * @editUser hx1098
 * @editTime 2022/9/23 06:11
 * @editDescription
 */
public class Main {
    public static void main(String[] args) {
//        Course_V01 course = new Course_V01();
//        course.study("直播课");
//        course.study("录播课");


        Course_V02_LiveCouse liveCouse = new Course_V02_LiveCouse();
        liveCouse.study("直播课");
        Course_V02_ReplayCouse replayCouse = new Course_V02_ReplayCouse();
        replayCouse.study("录播课");


    }

}
