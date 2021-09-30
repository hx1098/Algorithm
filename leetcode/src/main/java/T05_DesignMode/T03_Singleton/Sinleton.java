package T05_DesignMode.T03_Singleton;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/9/30 9:19
 * @description
 * @editUser hx
 * @editTime 2021/9/30 9:19
 * @editDescription
 */
public class Sinleton {

    /**私有化构造方法*/
    public Sinleton() { }

    /**私有化一个实例变量, 加上final 彻底解决了会出现多个实例的情况.*/
    private static final Sinleton instance = new Sinleton();

    public synchronized static Sinleton getInstance() {
        return instance;
    }
}
