package T05_DesignMode.T03_Singleton;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/9/30 9:13
 * @description
 * @editUser hx
 * @editTime 2021/9/30 9:13
 * @editDescription 单例模式 好比一个国家里只能有一个皇帝, 一个人只能有一个girlFriend, 2
 */
public class TestSingletion {

    public static void main(String[] args) {

        Sinleton instance = Sinleton.getInstance();
        Sinleton instance1 = Sinleton.getInstance();

        //看看返回的是不是同一个对象.
        System.out.println(instance == instance1);
    }

}
