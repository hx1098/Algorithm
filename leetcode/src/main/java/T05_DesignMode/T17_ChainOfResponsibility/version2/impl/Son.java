package T05_DesignMode.T17_ChainOfResponsibility.version2.impl;

import T05_DesignMode.T17_ChainOfResponsibility.version2.Handler;
import T05_DesignMode.T17_ChainOfResponsibility.version2.IWomen;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/10/25 15:24
 * @description
 * @editUser hx
 * @editTime 2021/10/25 15:24
 * @editDescription 在古代时候, 丧偶之后, 儿子欧决定权
 */
public class Son extends Handler {


    /**
     *儿子只处理 级别为3的请求
     */
    public Son() {
        super(SON_LEVEL_REQUEST);
    }

    /**儿子的请示答复*/
    @Override
    protected void response(IWomen women) {
        System.out.println("-------母亲向儿子请示-------");
        System.out.println(women.getRequest());
        System.out.println("儿子的答复是:同意\n");
    }
}
