package T05_DesignMode.T17_ChainOfResponsibility.version2.impl;

import T05_DesignMode.T17_ChainOfResponsibility.version2.Handler;
import T05_DesignMode.T17_ChainOfResponsibility.version2.IWomen;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/10/25 15:21
 * @description
 * @editUser hx
 * @editTime 2021/10/25 15:21
 * @editDescription 还是再古代, 出嫁以后的女子, 出去玩只能有丈夫决定,
 *  丈夫只处理 级别为2的请求
 *  构造方法是必须实现的.
 */
public class Husband  extends Handler {


    /**
     *丈夫只处理 级别为2的请求
     */
    public Husband() {
        super(HUSBAND_LEVEL_REQUEST);
    }

    /**丈夫的请示答复*/
    @Override
    protected void response(IWomen women) {
        System.out.println("--------妻子向丈夫请示-------");
        System.out.println(women.getRequest());
        System.out.println("丈夫的答复是:同意\n");
    }
}
