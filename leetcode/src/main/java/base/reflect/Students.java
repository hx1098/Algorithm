package base.reflect;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/10/5 15:08
 * @description
 * @editUser hx
 * @editTime 2021/10/5 15:08
 * @editDescription
 */
public class Students extends Person {

    public String ClassName;

    private String address;

    public Students() {
        //可以调用父类的.
        super();
    }

    private Students(String amme,String age,String className, String address) {
        super(amme,age);
        ClassName = className;
        this.address = address;
    }

    public String getClassName() {
        return ClassName;
    }

    public void setClassName(String ClassName) {
        this.ClassName = ClassName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
