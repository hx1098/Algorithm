package T05_DesignMode.T17_ChainOfResponsibility.version2.impl;

import T05_DesignMode.T17_ChainOfResponsibility.version2.IWomen;
import com.sun.media.jfxmedia.control.VideoRenderControl;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/10/24 13:32
 * @description
 * @editUser hx
 * @editTime 2021/10/24 13:32
 * @editDescription women接口的实现类,  women 类的构造函数做了一些改变
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
        switch (this.type) {
            case 1:
                this.request = "女儿的请求是: " + request;
                break;
            case 2:
                this.request = "妻子的请求是: " + request;
                break;
            case 3:
                this.request = "母亲的请求是: " + request;
                break;

        }

    }

    @Override
    public int getType() {
        return this.type;
    }

    @Override
    public String getRequest() {
        return this.request;
    }
}
