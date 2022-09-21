package T09_spring.T01_designPrinciple.T01_open_closed_principle;

/**
 * @author hx1098
 * @version 1.0.0
 * @createTime 2022/9/22 06:20
 * @description
 * @editUser hx1098
 * @editTime 2022/9/22 06:20
 * @editDescription
 */
public class JavaCourse implements ICourse{

    private Integer ID;
    private String name;
    private Double price;


    public JavaCourse(Integer ID, String name, Double price) {
        this.ID = ID;
        this.name = name;
        this.price = price;
    }

    @Override
    public Integer getId() {
        return this.ID;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Double getPrice() {
        return this.price;
    }

}
