package T09_spring.T01_designPrinciple.T04_interface_segregation_principle.V02;

/**
 * @author hx1098
 * @version 1.0.0
 * @createTime 2022/9/23 06:50
 * @description  接口隔离原则
 * @editUser hx1098
 * @editTime 2022/9/23 06:50
 * @editDescription   dog类只需要实现eat类和swim 类 就可以
 */
public class Dog implements ISwimAnimal,IEatAnimal{
    @Override
    public void eat() {

    }

    @Override
    public void swim() {

    }

    public static void main(String[] args) {

    }
}
