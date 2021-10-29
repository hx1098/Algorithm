package T05_DesignMode.T19_State.version2;

import T05_DesignMode.T19_State.version2.impl.Lift;

import java.util.List;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/10/29 11:04
 * @description
 * @editUser hx
 * @editTime 2021/10/29 11:04
 * @editDescription 看如何进行调用
 */
public class Client {

    public static void main(String[] args) {

        //创造出一个电梯出来
        ILift lift = new Lift();

        //  电梯的初始状态应该是听停止的状态
        lift.setState(ILift.STOPING_STATUS);

        System.out.println("----------电梯开门, 人要进去了----------------------");
        lift.open();

        System.out.println("-----------电梯关闭了,---------------------");
        lift.close();

        System.out.println("-----------电梯进入运行状态了---------------------");
        lift.run();

        System.out.println("-----------电梯停止了---------------------");
        lift.stop();

    }

}
