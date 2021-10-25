package T05_DesignMode.T17_ChainOfResponsibility.version1.impl;

import T05_DesignMode.T17_ChainOfResponsibility.version1.IHandler;
import T05_DesignMode.T17_ChainOfResponsibility.version1.IWomen;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/10/25 15:24
 * @description
 * @editUser hx
 * @editTime 2021/10/25 15:24
 * @editDescription 在古代时候, 丧偶之后, 儿子欧决定权
 */
public class Son implements IHandler {

    /**请示自己的儿子*/
    @Override
    public void HandleMessage(IWomen women) {
        System.out.println("母亲的请示是: " + women.getRequest());
        // 儿子总是要对自己的母亲应有的尊敬的....
        System.out.println("儿子的回答是: 同意");
    }
}
