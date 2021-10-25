package T05_DesignMode.T17_ChainOfResponsibility.version1.impl;

import T05_DesignMode.T17_ChainOfResponsibility.version1.IHandler;
import T05_DesignMode.T17_ChainOfResponsibility.version1.IWomen;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/10/25 15:18
 * @description
 * @editUser hx
 * @editTime 2021/10/25 15:18
 * @editDescription 在古代,没出嫁的自己是没有决定权的,未出嫁的女孩子只能请求自己的父亲,
 */
public class Father implements IHandler {


    /**
     * 未出嫁的女孩子来请求自己的父亲
     * @param women
     */
    @Override
    public void HandleMessage(IWomen women) {
        System.out.println("女儿的请示是: " + women.getRequest());
        System.out.println("父亲的回答是： 同意");
    }
}
