package T05_DesignMode.T17_ChainOfResponsibility.version1.impl;

import T05_DesignMode.T17_ChainOfResponsibility.version1.IHandler;
import T05_DesignMode.T17_ChainOfResponsibility.version1.IWomen;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/10/25 15:21
 * @description
 * @editUser hx
 * @editTime 2021/10/25 15:21
 * @editDescription 还是再古代, 出嫁以后的女子, 出去玩只能有丈夫决定,
 */
public class Husband  implements IHandler {

    /**请示 自己的丈夫*/
    @Override
    public void HandleMessage(IWomen women) {
        System.out.println("妻子的请示是: " + women.getRequest());
        // 总不能让人家一直待在家里, 多不好, 出毛了可咋办?
        System.out.println("丈夫的回答是:  同意, ");
    }
}
