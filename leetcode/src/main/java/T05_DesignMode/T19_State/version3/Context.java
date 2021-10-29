package T05_DesignMode.T19_State.version3;

import T05_DesignMode.T19_State.version3.impl.ClosingState;
import T05_DesignMode.T19_State.version3.impl.OpeningState;
import T05_DesignMode.T19_State.version3.impl.RunningState;
import T05_DesignMode.T19_State.version3.impl.StoppingState;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/10/29 14:31
 * @description
 * @editUser hx
 * @editTime 2021/10/29 14:31
 * @editDescription context是一个环境角色, 他的作用是串联各个状态下的过度,
 *
 *  也就是四个具体的实现类中根据自己的环境来决定如何进行状态的过度
 *
 */
public class Context {

    //    定义出所有电梯的状态,
    public static final OpeningState openingStates = new OpeningState();
    public static final ClosingState closingStates = new ClosingState();
    public static final RunningState runningStates = new RunningState();
    public static final StoppingState stoppingState = new StoppingState();

    /**定一个电梯状态*/
    private LiftState liftState;

    public LiftState getLiftState() {
        return liftState;
    }

    public void setLiftState(LiftState liftState) {
        this.liftState = liftState;
        //把当前环境通知到各个实现类当中
        this.liftState.setContext(this);
    }

    public void open() {
        this.liftState.open();
    }
    public void close() {
        this.liftState.close();
    }
    public void stop() {
        this.liftState.stop();
    }
    public void run() {
        this.liftState.run();
    }

}

