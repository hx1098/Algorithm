package T05_DesignMode.T16_Observer.version1.impl;

import T05_DesignMode.T16_Observer.version1.ILiSi;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/10/22 17:04
 * @description
 * @editUser hx
 * @editTime 2021/10/22 17:04
 * @editDescription 这里的李斯十一二观察者, 只要韩非子一察觉到有动静, 这边就会知道
 */
public class LiSi implements ILiSi {

    /**首先李斯是个观察者, 一旦韩非子有活动,他就知道, 他就要向老板汇报*/
    @Override
    public void update(String context) {
        System.out.println("李斯: 观察到韩非子活动,开始向老板汇报,,,吧啦吧啦");
        this.reportToQiShiHuang(context);
        System.out.println("李斯: 汇报完毕, 秦老板赏他两个萝卜吃吃...\n");
    }

    /**给秦始皇汇报*/
    private void reportToQiShiHuang(String context) {
        System.out.println("李斯: 报告老板,韩非子有新的活动了, 敌军还有三十秒到达战场..." + context);
    }
}
