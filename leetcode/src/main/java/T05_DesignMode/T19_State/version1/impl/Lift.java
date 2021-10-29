package T05_DesignMode.T19_State.version1.impl;

import T05_DesignMode.T19_State.version1.ILift;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/10/29 11:02
 * @description
 * @editUser hx
 * @editTime 2021/10/29 11:02
 * @editDescription 电梯的实现类
 */
public class Lift  implements ILift {

    @Override
    public void open() {
        System.out.println("电梯门打开了...");
    }

    @Override
    public void close() {
        System.out.println("电梯门关闭了...");
    }

    @Override
    public void run() {
        System.out.println("电梯上下跑起来了...");
    }

    @Override
    public void stop() {
        System.out.println("电梯停止了...");
    }
}
