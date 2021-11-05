package T05_DesignMode.T23_FlyWeight;

import T05_DesignMode.T23_FlyWeight.impl.Circle;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/11/4 15:01
 * @description
 * @editUser hx
 * @editTime 2021/11/4 15:01
 * @editDescription 通过传递颜色来获取实体类的对象
 */
public class FlyweightPatternDemo {

    public static final String[] colors = {"Red", "Green", "Blue", "White", "Black"};

    private static String  getRandomColor() {
        return colors[(int) Math.random() * colors.length];
    }
    private static int getRandomX() {
        return (int) (Math.random() * 100);
    }
    private static int getRandomY() {
        return (int) (Math.random() * 100);
    }

    public static void main(String[] args) {
        for(int i=0; i < 20; ++i) {
            Circle circle =
                    (Circle)ShapeFactory.getCircle(getRandomColor());
            circle.setX(getRandomX());
            circle.setY(getRandomY());
            circle.setRadius(100);
            circle.draw();
        }
    }

}
