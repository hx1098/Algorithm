package T05_DesignMode.T01_strategy.impl;

/**
 * @author hx
 * @createTime 2021/9/29 15:29
 * @version 1.0.0
 * @description
 * @editUser hx
 * @editTime 2021/9/29 15:29
 * @editDescription 孙夫人断后, 挡住追兵..
 */
public class BlockEnemy  implements IStrategy{

    @Override
    public void operate() {
        System.out.println("孙夫人断后, 挡住追兵.....");
    }
}
