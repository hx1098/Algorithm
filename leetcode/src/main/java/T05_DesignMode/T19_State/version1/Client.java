package T05_DesignMode.T19_State.version1;

import T05_DesignMode.T19_State.version1.impl.Lift;

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


        ILift lift = new Lift();

        lift.open();
        lift.run();
        lift.close();
        lift.stop();


    }

}
