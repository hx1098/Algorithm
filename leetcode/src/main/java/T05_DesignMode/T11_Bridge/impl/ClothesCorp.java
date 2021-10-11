package T05_DesignMode.T11_Bridge.impl;

import T05_DesignMode.T11_Bridge.Corp;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/10/11 21:45
 * @description
 * @editUser hx
 * @editTime 2021/10/11 21:45
 * @editDescription 再看看我的服饰公司, 专做A货, 主要是行当不怎么样,
 *   但是还是可以赚点小钱的.
 *
 *
 *   传统公司
 */
public class ClothesCorp extends Corp {

    /**
     * 服饰公司生产的就是服饰了.
     */
    @Override
    protected void produce() {
        System.out.println("服饰公司生产服饰了....买买买");
    }

    /**
     * 服饰公司卖衣服, 可不是只做生产的.
     */
    @Override
    protected void sell() {
        System.out.println("服饰公司销售衣服了....");
    }

    @Override
    public void makeMoney() {
        super.makeMoney();
        System.out.println("服饰公司赚的都是小钱....");
    }


}
