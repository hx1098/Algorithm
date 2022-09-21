package T09_spring.T01_designPrinciple.T02_dependence_inversion_principle;

/**
 * @author hx1098
 * @version 1.0.0
 * @createTime 2022/9/22 06:23
 * @description
 * @editUser hx1098
 * @editTime 2022/9/22 06:23
 * @editDescription  现在课程在贱卖
 */
public class PythonCourse implements ICourse {

    @Override
    public void study() {
        System.out.println("TOM在学习python课程");

    }
}
