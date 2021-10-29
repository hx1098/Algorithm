/*
package T05_DesignMode.T19_State.version3.impl;

import T05_DesignMode.T19_State.version3.ILift;

*/
/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/10/29 11:02
 * @description
 * @editUser hx
 * @editTime 2021/10/29 11:02
 * @editDescription 电梯的实现类
 *//*

public class Lift  implements ILift {

    */
/**电梯的状态*//*

    private int state;

    */
/**设置电梯的状态*//*

    @Override
    public void setState(int state) {
        this.state = state;
    }

    @Override
    public void open() {
        switch (this.state) {
            //如果是则可以关门, 同时修改电梯的状态
            case OPENING_STATUS:
                break;
            //如果电梯的门是关闭的, 则可以进行开启
            case CLOSEING_STATUS:
                this.openWithoutLogic();
                this.setState(OPENING_STATUS);
                break;
            //    如果是运行状态, 则什么都不做
            case RUNNING_STATUS:
                break;
            //    如果是停状态, 则可以进行开启
            case STOPING_STATUS:
                this.openWithoutLogic();
                this.setState(OPENING_STATUS);
                break;
            default:
                System.out.println("电梯升天了,  异常.");
        }
    }

    @Override
    public void close() {
        System.out.println("开始关闭了..");
        switch (this.state) {
            //如果是则可以关门, 同时修改电梯的状态
            case OPENING_STATUS:
                this.closeWithoutLogic();
                this.setState(CLOSEING_STATUS);
                break;
            //如果电梯的门是关闭的, 则什么都不做
            case CLOSEING_STATUS:
                //do noting
                break;
            //    如果是运行状态, 则什么都不做
            case RUNNING_STATUS:
                break;
            //    如果是停状态, 本来也是关闭的, 什么都不做
            case STOPING_STATUS:
                break;
            default:
                System.out.println("电梯升天了,  异常.");
        }
    }




    @Override
    public void run() {
        System.out.println("开始关闭...");
        switch (this.state) {
            //如果是开门状态, 你就不能运行, 什么也不做
            case OPENING_STATUS:
                break;
            //如果电梯的门是关闭的, 则可以进行运行
            case CLOSEING_STATUS:
                this.runWithoutLogic();
                this.setState(RUNNING_STATUS);
                break;
            //    如果是运行状态, 则什么都不做
            case RUNNING_STATUS:
                break;
            //    如果是停止状态, 则可以运行
            case STOPING_STATUS:
                this.runWithoutLogic();
                this.setState(RUNNING_STATUS);
                break;
            default:
                System.out.println("电梯升天了,  异常.");
        }
    }

    @Override
    public void stop() {
        System.out.println("开始停止...");
        switch (this.state) {
            //如果是开门状态,那肯定要停止下来, 什么都不用做
            case OPENING_STATUS:
                break;
            //如果电梯的门是关闭的, 则可以进行进行停止的状态
            case CLOSEING_STATUS:
                this.stopWithoutLogic();
                this.setState(CLOSEING_STATUS);
                break;
            //    如果是运行状态, 就可以进入运行装填
            case RUNNING_STATUS:
                this.stopWithoutLogic();
                this.setState(CLOSEING_STATUS);
                break;
            //    如果是停止状态, 则可以运行
            case STOPING_STATUS:
                break;
            default:
                System.out.println("电梯升天了,  异常.");
        }
    }

    */
/**纯粹的电梯关门,不考虑实际情况*//*

    private void closeWithoutLogic() {
        System.out.println("电梯门关闭....");
    }
    */
/**纯粹的电梯开门,不考虑实际情况*//*

    private void  openWithoutLogic() {
        System.out.println("电梯门'开启'....");
    }
    */
/**纯粹的电梯运行,不考虑实际情况*//*

    private void runWithoutLogic() {
        System.out.println("电梯上下跑起来....");
    }
    */
/**纯粹的电梯停止,不考虑实际情况*//*

    private void stopWithoutLogic() {
        System.out.println("电梯停止了....");
    }

}
*/
