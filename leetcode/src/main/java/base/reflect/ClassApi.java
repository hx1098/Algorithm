package base.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/10/5 15:05
 * @description
 * @editUser hx
 * @editTime 2021/10/5 15:05
 * @editDescription
 */
public class ClassApi {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, InstantiationException {
        Class<?> clazz = Class.forName("base.reflect.Students");
        Field[] fields = clazz.getFields();
        for (Field field : fields) {
            System.out.println(field);
            System.out.println(field.getName());
            System.out.println(field.getType());
            System.out.println(field.getModifiers());
            System.out.println("==============");
        }

        System.out.println("-----------------------------");
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField.getName());
        }


        System.out.println("------------------------------");
        Field address = clazz.getDeclaredField("address");
        //      反射一定程度上破坏了封装性,需要合理的使用.
        //      设置改属性能否被访问, 默认私有的属性是会报错的.
        address.setAccessible(true);
        System.out.println(address.getName());
        Object o = clazz.newInstance();
        address.set(o, "北京市");
        System.out.println(((Students) o).getAddress());


        System.out.println("--------------------------------");
        //    获取普通方法(包含所有的, object, 父类方法)
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
        }
        System.out.println("==========================================");
        //    获取当前类的方法
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField.getName());
        }


        System.out.println("=======================================");
        //构造方法(构造方法的话不会获取父类的)
        Constructor<?>[] constructors = clazz.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor.getName());
        }
        System.out.println("----------");
        //只能获取共有的构造方法
        Constructor<?>[] constructors1 = clazz.getDeclaredConstructors();
        for (Constructor<?> constructor : constructors1) {
            System.out.println(constructor.getName());
        }

    //

    }


}
