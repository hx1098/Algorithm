package T05_DesignMode.T06_AbstractFactory.factoryImpl;

import T05_DesignMode.T06_AbstractFactory.AbstractHumanFactory;
import T05_DesignMode.T06_AbstractFactory.Human;
import T05_DesignMode.T06_AbstractFactory.HumanEnum;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/10/6 21:12
 * @description
 * @editUser hx
 * @editTime 2021/10/6 21:12
 * @editDescription 女性创建工厂
 */
public class FemaleHumanFactory extends AbstractHumanFactory {

    /**女性黄种人*/
    @Override
    public Human createYellowHuman() {
        return super.createHuman(HumanEnum.YelloFemaleHuman);
    }

    /**女性白种人*/
    @Override
    public Human createWhiteHuman() {
        return super.createHuman(HumanEnum.WhiteFemaleHuman);
    }

    /**女性黑种人*/
    @Override
    public Human createBlackHuman() {
        return super.createHuman(HumanEnum.BlackFemaleHuman);
    }
}
