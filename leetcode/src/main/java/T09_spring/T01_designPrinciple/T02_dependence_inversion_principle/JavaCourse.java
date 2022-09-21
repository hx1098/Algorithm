package T09_spring.T01_designPrinciple.T02_dependence_inversion_principle;

/**
 * @author hx1098
 * @version 1.0.0
 * @createTime 2022/9/22 06:20
 * @description
 * @editUser hx1098
 * @editTime 2022/9/22 06:20
 * @editDescription 高层模块不应该依赖底层模块，二者都应该依赖其抽象
 */
public class JavaCourse implements ICourse {

    @Override
    public void study() {
        System.out.println("TOM在学习java课程");
    }
}
