package T05_DesignMode.T19_State.version1;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/10/29 10:59
 * @description
 * @editUser hx
 * @editTime 2021/10/29 10:59
 * @editDescription 定义一个电梯的接口
 */
public interface ILift {

    /**电梯门开启的动作*/
    public void open();

    /**关系电梯门*/
    public void close();

    /**电梯门要能上能下, 哎, 跑起来跑起来*/
    public void run();

    /**电梯要能停下来, 根本停不下来不就完蛋了..*/
    public void stop();




}
