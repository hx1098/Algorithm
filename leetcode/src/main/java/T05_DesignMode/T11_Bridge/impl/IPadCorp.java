package T05_DesignMode.T11_Bridge.impl;

import T05_DesignMode.T11_Bridge.Corp;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/10/11 21:57
 * @description
 * @editUser hx
 * @editTime 2021/10/11 21:57
 * @editDescription 有一天老板转换了思路, 卖山寨的ipad, 虽然价格不贵, 但是受欢迎啊, 赚钱啊....
 *  我是山寨老大, 你流行啥我就生产啥
 */
public class IPadCorp extends Corp {

    /**换换思路, 我生产ipad 了*/
    @Override
    protected void produce() {
        System.out.println("我开始生产ipadl ......, 流行啊, 赚钱啊, 你买不买吧....");
    }

    /**换换思路, 我开始销售电子产品了....*/
    @Override
    protected void sell() {
        System.out.println("哇塞, ipad很畅销啊,,,,");
    }

    /**资本家的丑恶嘴脸暴露无疑, */
    @Override
    public void makeMoney() {
        super.makeMoney();
        System.out.println("我突然一页暴富了, 太赚钱了.....");
    }
}
