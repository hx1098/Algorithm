package T05_DesignMode.T23_FlyWeight.impl;

import T05_DesignMode.T23_FlyWeight.Shape;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/11/4 14:45
 * @description
 * @editUser hx
 * @editTime 2021/11/4 14:45
 * @editDescription
 */
public class Circle implements Shape {

    private String color;
    private int x,y, radius;

    public Circle(String color) {
        this.color = color;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.println("Circle: Draw() [color:" + color + ", x: " +x + ", y" +y + ", radius" + radius);
    }
}
