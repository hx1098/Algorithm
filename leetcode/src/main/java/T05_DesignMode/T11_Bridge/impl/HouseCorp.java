package T05_DesignMode.T11_Bridge.impl;

import T05_DesignMode.T11_Bridge.Corp;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/10/11 21:39
 * @description
 * @editUser hx
 * @editTime 2021/10/11 21:39
 * @editDescription 这可是我最赚钱的公司, 房地产公司,
 *
 *
 *
 * 传统公司
 */
public class HouseCorp extends Corp {


    /**
     * 房地产公司就是盖房子,
     */
    @Override
    protected void produce() {
        System.out.println("房地产公司拿着我的钱去盖房子了, 呜呜呜....");
    }

    /**
     * 房地产盖房子用来卖的, 自己住也没那摩多人, 可不赚钱
     */
    @Override
    protected void sell() {
        System.out.println("房产公司来做说客了....");
    }

    /**
     * 房产公司赚钱了, 开始数钱
     */
    @Override
    public void makeMoney() {
        super.makeMoney();
        System.out.println("房地产公司赚大钱了.....");
    }


}
