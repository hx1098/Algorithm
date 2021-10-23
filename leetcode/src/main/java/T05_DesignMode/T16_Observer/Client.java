package T05_DesignMode.T16_Observer;

import T05_DesignMode.T16_Observer.impl.HanFeiZi;
import T05_DesignMode.T16_Observer.impl.LiSi;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/10/23 10:12
 * @description
 * @editUser hx
 * @editTime 2021/10/23 10:12
 * @editDescription 这个client 就是我们, 用我们的视角看这段历史
 */
public class Client {
    public static void main(String[] args) throws InterruptedException {
        //    定义出韩非子和李斯
        LiSi liSi = new LiSi();
        HanFeiZi hanFeiZi = new HanFeiZi();

        //观察早餐
        Watch watchBreakfast = new Watch(liSi, hanFeiZi, "breakfast");
        //开始启动线程进行监控
        //watchBreakfast.start();
        watchBreakfast.run();

        //    观察娱乐情况
        Watch watchFun = new Watch(liSi, hanFeiZi, "fun");
        //watchFun.start();
        watchFun.run();


        //然后这里我们看韩非子在干什么, 主线程等待1秒钟之后再往下执行
        Thread.sleep(1000);
        hanFeiZi.haveBreakfast();


        //韩非子娱乐了...
        Thread.sleep(1000);
        hanFeiZi.haveFun();
    }

}
