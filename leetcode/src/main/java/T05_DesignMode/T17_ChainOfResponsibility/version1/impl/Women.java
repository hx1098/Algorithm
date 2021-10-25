package T05_DesignMode.T17_ChainOfResponsibility.version1.impl;

import T05_DesignMode.T17_ChainOfResponsibility.version1.IWomen;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/10/24 13:32
 * @description
 * @editUser hx
 * @editTime 2021/10/24 13:32
 * @editDescription women接口的实现类,
 */
public class Women implements IWomen {

      /** 通过一个参数来描述一个妇女的家庭qingkuang
     * 1: 未出嫁
     * 2: 出嫁
     * 3: 丧偶
     * @return
     */
    private int type = 0;
    /**该女子的请求*/
    private String request = "";

    /**构造函数触底过来的请求*/
    public Women(int type, String request) {
        this.type = type;
        this.request = request;
    }

    /**获取当前的type类型*/
    @Override
    public int getType() {
        return this.type;
    }

    /**活的那个女孩的请求*/
    @Override
    public String getRequest() {
        return this.request;
    }
}
