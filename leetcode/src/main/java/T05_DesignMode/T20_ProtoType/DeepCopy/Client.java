package T05_DesignMode.T20_ProtoType.DeepCopy;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/10/30 9:28
 * @description
 * @editUser hx
 * @editTime 2021/10/30 9:28
 * @editDescription
 *
 * 个偷懒的拷贝动作,
 *
 * 法 clone 只是拷贝本对象，
 * 其对象内部的数组、引用对象等都不拷贝，还是指向原生对象的内部元素地址，这种拷贝就叫做浅拷贝
 */
public class Client {

    public static void main(String[] args) throws CloneNotSupportedException {
        //创建一个对象并设置值
        Thing thing = new Thing();
        thing.setValue("张三");

        Thing clone = (Thing) thing.clone();
        clone.setValue("李斯");

        System.out.println(thing.getValue());

//[张三, 李四]
    }
}
