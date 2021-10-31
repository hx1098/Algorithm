package T05_DesignMode.T20_ProtoType.littleThings;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/10/30 9:17
 * @description
 * @editUser hx
 * @editTime 2021/10/30 9:17
 * @editDescription
 */
public class Thing implements Cloneable{

    public Thing() {
        System.out.println("构造函数被执行了....");
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Thing thing = null;
        thing =  (Thing)super.clone();
        return thing;
    }
}
