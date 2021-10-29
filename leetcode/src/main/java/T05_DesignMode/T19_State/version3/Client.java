package T05_DesignMode.T19_State.version3;

import T05_DesignMode.T19_State.version3.impl.ClosingState;

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
    /**
     * 但是, 总感觉哪里不对劲儿, 这种调用完全不用管状态的变更, 看运行结果
     *
     *
     *
     * */

    public static void main(String[] args) {
        Context context = new Context();
        context.setLiftState(new ClosingState());
        context.open();
        context.close();
        context.run();
        context.stop();



    }

}
