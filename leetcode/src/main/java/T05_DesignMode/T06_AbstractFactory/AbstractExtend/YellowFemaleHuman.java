package T05_DesignMode.T06_AbstractFactory.AbstractExtend;

import T05_DesignMode.T06_AbstractFactory.AbstractImpl.AbstractYelloHuman;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/10/6 19:54
 * @description
 * @editUser hx
 * @editTime 2021/10/6 19:54
 * @editDescription 女性黄种人
 */
public class YellowFemaleHuman extends AbstractYelloHuman {

    @Override
    public void sex() {
        System.out.println("该黄种人性别为女...");
    }
}
