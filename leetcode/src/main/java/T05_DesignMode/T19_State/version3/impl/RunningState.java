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
 * @editDescription 电梯在运行状态下能做哪些动作.
 */
public class RunningState extends LiftState {

    /**运行状态下电梯是不可能给你开门的, 除非是电梯异常.*/
    @Override
    public void open() {
        //    do noting
    }

    /**电梯运行状态下们肯定是关闭的了*/
    @Override
    public void close() {

    }

    /**运行状态下肯定是要进行停止的, 不然谁还敢坐电梯呀*/
    @Override
    public void stop() {
        //状态修改, 为停止状态
        super.context.setLiftState(Context.stoppingState);
        //动作委托
        super.context.getLiftState().stop();
    }

    /**运行状态下肯定是上下跑的*/
    @Override
    public void run() {
        System.out.println("电梯上下跑.........");
    }
}
