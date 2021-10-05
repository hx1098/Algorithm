package T05_DesignMode.T04_Multition;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/10/4 20:12
 * @description
 * @editUser hx
 * @editTime 2021/10/4 20:12
 * @editDescription 大臣们就比较悲惨了, 一个皇帝都伺候不过来了, 现在还来了两个皇帝.
 * TMD, 找到个皇帝, 只要请安, 磕头就行了,
 */
public class Minister {
    public static void main(String[] args) {

        int ministerNum = 10;
        for (int i = 0; i < ministerNum; i++) {
            Emperor emperor = Emperor.getInstance();
            System.out.println("第" + i+ "个参拜的大臣是:" );
            Emperor.emperorInfo();
        }
    }


}
