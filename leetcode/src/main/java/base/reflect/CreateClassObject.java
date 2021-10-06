package base.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/10/5 14:32
 * @description
 * @editUser hx
 * @editTime 2021/10/5 14:32
 * @editDescription 三种获取对象的方式.
 */
public class CreateClassObject {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //    通过class.forName 获取Class对象
        Class clazz = Class.forName("base.reflect.Person");
        System.out.println(clazz.getName());
        System.out.println(clazz.getPackage());
        System.out.println(clazz.getSimpleName());
        System.out.println(clazz.getCanonicalName());

        //    通过类名来来获取
        Class<Person> personClass = Person.class;
        System.out.println(personClass.getName());
        System.out.println(personClass.getSimpleName());
        System.out.println(personClass.getPackage());
        System.out.println(personClass.getCanonicalName());
        //System.out.println(personClass.getField("age"));

        //    通过对象的getClass()获取
        Class<? extends Person> aClass = new Person().getClass();
        System.out.println(aClass.getSimpleName());
        System.out.println(aClass.getName());
        System.out.println(aClass.getCanonicalName());


        System.out.println("===============================================");
        //    如果是一个基本类型, 可以通过这种方式来获取中文的
        Class<Integer[]> aClass1 = Integer[].class;
        System.out.println(aClass1.getName());
        System.out.println(aClass1.getCanonicalName());


        System.out.println("===================123===========================111111111111111");
        Constructor<?> constructor = clazz.getDeclaredConstructor(String.class, String.class, String.class);
        constructor.setAccessible(true);
        Person zhangsan = (Person)constructor.newInstance("zhangsan", "23", "1996");
        System.out.println(zhangsan.show());



    }
}
