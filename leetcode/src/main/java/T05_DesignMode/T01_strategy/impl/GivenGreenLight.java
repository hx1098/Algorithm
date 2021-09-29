package T05_DesignMode.T01_strategy.impl;

/**
 * @author hx
 * @createTime 2021/9/29 15:22
 * @version 1.0.0
 * @description
 * @editUser hx
 * @editTime 2021/9/29 15:22
 * @editDescription 求吴国太 开个绿灯
 */
public class GivenGreenLight implements IStrategy{

    @Override
    public void operate() {
        System.out.println("求吴国太给开个绿灯....");
    }
}
