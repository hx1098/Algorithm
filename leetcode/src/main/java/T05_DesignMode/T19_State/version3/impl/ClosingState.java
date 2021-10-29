package T05_DesignMode.T19_State.version3.impl;

import T05_DesignMode.T19_State.version3.Context;
import T05_DesignMode.T19_State.version3.LiftState;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/10/29 14:35
 * @description
 * @editUser hx
 * @editTime 2021/10/29 14:35
 * @editDescription 电梯门关闭以后可以做哪些事情
 */
public class ClosingState extends LiftState {


    /**电梯门关闭后, 有打开了, 逗你玩呢,但这个是允许的.*/
    @Override
    public void open() {
        //设置电梯门为敞开状态
        super.context.setLiftState(Context.openingStates);
        //委托LiftState类, 打开电梯门
        super.context.getLiftState().open();
    }
    /**电梯门本来就是关闭的, 这是关闭状态要实现的动作*/
    @Override
    public void close() {
        System.out.println("电梯门关闭了..");
    }

    /**电梯门关着, 但是我就不按楼层*/
    @Override
    public void stop() {
        // 设置为停止状态
        super.context.setLiftState(Context.stoppingState);
        //调用委托, 设置为听停止状态
        super.context.getLiftState().stop();
    }

    /**电梯关了, 就开始进行运行状态*/
    @Override
    public void run() {
        //设置为运行状态
        super.context.setLiftState(Context.runningStates);
        //调用委托, 进行运行状态
        super.context.getLiftState().run();
    }
}
