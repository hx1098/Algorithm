package T09_spring.T01_designPrinciple.T01_open_closed_principle;

/**
 * @author hx1098
 * @version 1.0.0
 * @createTime 2022/9/22 06:23
 * @description
 * @editUser hx1098
 * @editTime 2022/9/22 06:23
 * @editDescription  现在课程在贱卖
 */
public class JavaDiscountCourse extends JavaCourse{

    public JavaDiscountCourse(Integer ID, String name, Double price) {
        super(ID, name, price);
    }

    public Double getOriginPrice() {
        return super.getPrice();
    }

    @Override
    public Double getPrice() {
        return super.getPrice() *0.61;
    }
}
