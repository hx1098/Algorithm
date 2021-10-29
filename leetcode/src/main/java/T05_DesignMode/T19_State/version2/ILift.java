package T05_DesignMode.T19_State.version2;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/10/29 10:59
 * @description
 * @editUser hx
 * @editTime 2021/10/29 10:59
 * @editDescription 定义一个电梯的接口 ,在原来的基础上增加电梯的四个状态,  电梯有四个状态, 同时还能进行设置状态
 */
public interface ILift {


    /**门敞状态*/
    public static final int  OPENING_STATUS = 1;
    /**门闭状态*/
    public static final int  CLOSEING_STATUS = 2;
    /**运行状态*/
    public static final int  RUNNING_STATUS = 3;
    /**停止状态*/
    public static final int  STOPING_STATUS = 4;

    /**设置电梯的状态*/
    public void setState(int state);

    /**电梯门开启的动作*/
    public void open();

    /**关系电梯门*/
    public void close();

    /**电梯门要能上能下, 哎, 跑起来跑起来*/
    public void run();

    /**电梯要能停下来, 根本停不下来不就完蛋了..*/
    public void stop();




}
