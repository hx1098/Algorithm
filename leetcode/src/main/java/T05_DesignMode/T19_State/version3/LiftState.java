package T05_DesignMode.T19_State.version3;

import java.beans.PropertyEditor;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/10/29 14:09
 * @description
 * @editUser hx
 * @editTime 2021/10/29 14:09
 * @editDescription 定义一个电梯状态的接口
 */
public abstract class LiftState {

    /**定义一个环境角色, 也就是封装状态变换引起的功能变化*/
    protected Context context;

    public void setContext(Context context) {
        this.context = context;
    }

    /**首先电梯门开的动作*/
    public abstract void open();

    /**首先电梯门关闭的动作*/
    public abstract void close();

    /**首先电梯停止运行的动作*/
    public abstract void stop();

    /**首先电梯门运行的动作*/
    public abstract void run();
}
