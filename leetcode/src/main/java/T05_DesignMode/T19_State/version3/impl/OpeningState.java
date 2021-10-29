package T05_DesignMode.T19_State.version3.impl;

import T05_DesignMode.T19_State.version3.Context;
import T05_DesignMode.T19_State.version3.LiftState;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/10/29 14:16
 * @description
 * @editUser hx
 * @editTime 2021/10/29 14:16
 * @editDescription 电梯能在开启的状态下能做什么事情
 */
public class OpeningState extends LiftState {

    /**
     * 打开电梯门
     */
    @Override
    public void open() {
        System.out.println("电梯门开启。。。。");
    }

    /**
     * 开启状态下当然可以进行关闭了, 我就是想测试一下电梯的开关功能, 哎我就是玩儿,,
     */
    @Override
    public void close() {
        //状态修改
        super.context.setLiftState(Context.closingStates);
        //动作委托为 closeStates来进行执行
        super.context.getLiftState().close();
    }

    @Override
    public void stop() {
        //    do nothing
    }

    @Override
    public void run() {
        //    do nothing
    }
}
