package T05_DesignMode.T20_ProtoType.littleThings;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/10/30 9:20
 * @description
 * @editUser hx
 * @editTime 2021/10/30 9:20
 * @editDescription clone 初始化的时候, 是否加载的构造函数
 */
public class Client {
    public static void main(String[] args) throws CloneNotSupportedException {
        //只有初始化的时候 构造函数被初始化了
        Thing thing = new Thing();

        //对象拷贝的时候, 构造函数没有被初始化
        Thing clone = (Thing) thing.clone();

    }

}
