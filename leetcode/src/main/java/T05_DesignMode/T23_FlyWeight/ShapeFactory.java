package T05_DesignMode.T23_FlyWeight;


import T05_DesignMode.T23_FlyWeight.impl.Circle;

import java.util.HashMap;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/11/4 14:56
 * @description
 * @editUser hx
 * @editTime 2021/11/4 14:56
 * @editDescription 创建一个工厂, 生成给定信息的实体类的对象
 */
public class ShapeFactory {

    private static final HashMap<String, Shape> circleMap = new HashMap<>();

    public static Shape getCircle(String color) {
        Circle circle = (Circle) circleMap.get(color);
        if (circle == null) {
            circle = new Circle(color);
            circleMap.put(color, circle);
            System.out.println("Creating circle of color:" + color);
        }
        return circle;
    }

}
