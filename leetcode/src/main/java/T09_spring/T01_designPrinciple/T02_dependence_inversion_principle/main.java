package T09_spring.T01_designPrinciple.T02_dependence_inversion_principle;

/**
 * @author hx1098
 * @version 1.0.0
 * @createTime 2022/9/22 06:34
 * @description
 * @editUser hx1098
 * @editTime 2022/9/22 06:34
 * @editDescription
 */
public class main {

    public static void main(String[] args) {
        //接口注入
//        Tom tom = new Tom();
//        tom.study(new JavaCourse());
//        tom.study(new PythonCourse());


        //构造注入
//        Tom tom = new Tom(new JavaCourse());
//        tom.study();

        //setter注入
        Tom tom = new Tom();
        tom.setCourse(new JavaCourse());
        tom.study();

    }

}
