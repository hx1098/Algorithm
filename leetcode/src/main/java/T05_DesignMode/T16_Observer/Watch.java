package T05_DesignMode.T16_Observer;

import T05_DesignMode.T16_Observer.impl.HanFeiZi;
import T05_DesignMode.T16_Observer.impl.LiSi;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/10/22 17:25
 * @description
 * @editUser hx
 * @editTime 2021/10/22 17:25
 * @editDescription 写一个监控程序, 监控韩非子的一切活动
 */
public class Watch extends Thread {


    private LiSi liSi;
    private HanFeiZi hanFeiZi;
    private String type;

    /**
     * 通过构造函数传递参数, 我要监控的是谁,谁来监控,要监控什么
     */
    public Watch(LiSi liSi, HanFeiZi hanFeiZi, String type) {
        this.liSi = liSi;
        this.hanFeiZi = hanFeiZi;
        this.type = type;
    }

    @Override
    public void run() {
        while (true) {
            //监控是否在吃早餐
            if (this.type.equals("breakfast")) {
                //  如果发现韩非子在吃饭, 就通知李斯
                if (this.hanFeiZi.getIsHaveBreakfast()) {
                    this.liSi.update("韩非在吃饭...");
                    //    重置状态, 继续监控
                    this.hanFeiZi.setIsHaveBreakfast(false);
                }
            } else {
                //    监控是不是在娱乐
                if (this.hanFeiZi.getIsHaveFun()) {
                    this.liSi.update("韩非子在娱乐....");
                    this.hanFeiZi.setIsHaveFun(false);
                }
            }
        }
    }

}
