package T05_DesignMode.T17_ChainOfResponsibility.version2.impl;

import T05_DesignMode.T17_ChainOfResponsibility.version2.Handler;
import T05_DesignMode.T17_ChainOfResponsibility.version2.IWomen;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/10/25 15:18
 * @description
 * @editUser hx
 * @editTime 2021/10/25 15:18
 * @editDescription 在古代,没出嫁的自己是没有决定权的,未出嫁的女孩子只能请求自己的父亲, 父亲只处理级别为1 的请求
 */
public class Father extends Handler {


    /**
     * 父亲只处理女儿的请求
     */
    public Father() {
        super(Handler.FATHER_LEVEL_REQUEST);
    }

    /**
     * 父亲的答复
     */
    @Override
    protected void response(IWomen women) {
        System.out.println("--------女儿向父亲请示-------");
        System.out.println(women.getRequest());
        System.out.println("父亲的答复是:同意\n");
    }


}