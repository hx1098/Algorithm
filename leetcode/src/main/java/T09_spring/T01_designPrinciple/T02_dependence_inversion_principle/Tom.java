package T09_spring.T01_designPrinciple.T02_dependence_inversion_principle;

/**
 * @author hx1098
 * @version 1.0.0
 * @createTime 2022/9/22 06:31
 * @description
 * @editUser hx1098
 * @editTime 2022/9/22 06:31
 * @editDescription
 */
public class Tom {

    //接口注入
//    public void studyJavaCourse() {
//        System.out.println("TOM在学习java课程");
//    }
//
//    public void studyPythonCourse() {
//        System.out.println("TOM在学习python课程");
//    }
//    public void study(ICourse course) {
//        course.study();
//    }


    //构造注入
//    private ICourse course;
//    public Tom(ICourse course) {
//        this.course = course;
//    }
//    public void study() {
//        course.study();
//    }



    //settter注入
    private ICourse course;
    public void setCourse(ICourse course) {
        this.course = course;
    }
    public void study() {
        course.study();
    }



}
