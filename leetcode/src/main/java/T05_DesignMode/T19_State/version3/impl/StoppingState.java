package T05_DesignMode.T19_State.version3.impl;

import T05_DesignMode.T19_State.version3.Context;
import T05_DesignMode.T19_State.version3.LiftState;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/10/29 14:36
 * @description
 * @editUser hx
 * @editTime 2021/10/29 14:36
 * @editDescription 在停止状态下能做什么事情
 */
public class StoppingState extends LiftState {

    /**停止状态下 是可以进行开门的。*/
    @Override
    public void open() {
        //设置状态
        super.context.setLiftState(Context.openingStates);
        //委托LiftState进行开门操作
        super.context.getLiftState().open();
    }

    /**停止状态下关门? 不好意思, 电梯停止的状态下门就是关闭的.*/
    @Override
    public void close() {
    //    do nothing
    }

    /**停止状态是如何发生的, 那当然是停止方法执行了.*/
    @Override
    public void stop() {
        System.out.println("电梯停止了....");
    }

    /**停止状态下  电梯可以再次跑起来的*/
    @Override
    public void run() {
        //设置状态,
        super.context.setLiftState(Context.runningStates);
        //委托LiftState类 让电梯进入运行装填.
        super.context.getLiftState().run();
    }
}
