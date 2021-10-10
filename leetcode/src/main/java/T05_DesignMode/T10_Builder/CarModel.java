package T05_DesignMode.T10_Builder;

import java.util.ArrayList;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/10/10 20:29
 * @description
 * @editUser hx
 * @editTime 2021/10/10 20:29
 * @editDescription 定义一个车辆的抽象类，所有的车辆模型都继承这里的类
 *
 * setSequence 是允许用户自己进行设定的.
 */
public abstract class CarModel {

    /**
     * 这个是记录各个方法执行的顺序
     */
    private ArrayList<String> sequence = new ArrayList<>();

    /**
     * 模型的启动
     */
    protected abstract void start();

    /**
     * 能发动，那还要能停下来，那才是真本事
     */
    protected abstract void stop();

    /**
     * 喇叭滴滴
     */
    protected abstract void alarm();

    /**
     * 引擎隆隆
     */
    protected abstract void engineBoom();

    /**
     * 循环一遍, 谁先就先执行谁
     */
    final public void run() {
        for (int i = 0; i < this.sequence.size(); i++) {
            String actionName = this.sequence.get(i);

            if (actionName.equalsIgnoreCase("start")) {
                this.start();
            } else if (actionName.equalsIgnoreCase("stop")) {
                this.stop();
            } else if (actionName.equalsIgnoreCase("alarm")) {
                this.alarm();
            } else if (actionName.equalsIgnoreCase("engine boom")) {
                this.engineBoom();
            }
        }
    }

    /**
     * 把传递过来值传递到类内.
     */
    final public void setSequence(ArrayList<String> sequence) {
        this.sequence = sequence;
    }
}