package T05_DesignMode.T09_TemplateMethod.v02;

import org.apache.commons.collections.bag.SynchronizedSortedBag;

/**
 * @author hx1098
 * @version 1.0.0
 * @createTime 2022/10/18 17:27
 * @description
 * @editUser hx1098
 * @editTime 2022/10/18 17:27
 * @editDescription
 */
public class main {


    public static void main(String[] args) {
        System.out.println("---java架构师课程----");
        NetWorkCourse course = new JavaCourse();
        course.createCourse();

        System.out.println("----bigData架构师课程----");
        NetWorkCourse workCourse = new BigdataCourse(true);
        workCourse.createCourse();

    }
}
