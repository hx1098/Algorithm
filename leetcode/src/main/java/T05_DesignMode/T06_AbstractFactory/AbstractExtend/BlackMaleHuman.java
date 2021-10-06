package T05_DesignMode.T06_AbstractFactory.AbstractExtend;

import T05_DesignMode.T06_AbstractFactory.AbstractImpl.AbstractBlackHuman;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/10/6 19:54
 * @description
 * @editUser hx
 * @editTime 2021/10/6 19:54
 * @editDescription 女性性黑种人
 */
public class BlackMaleHuman extends AbstractBlackHuman {

    @Override
    public void sex() {
        System.out.println("该黑种人性别为女...");
    }
}
