package T05_DesignMode.T16_Observer.version1.impl;

import T05_DesignMode.T16_Observer.version1.IHanFeiZi;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/10/22 16:53
 * @description
 * @editUser hx
 * @editTime 2021/10/22 16:53
 * @editDescription 再来看看他的实现类, 韩非子, 李斯的师弟, 韩国的重要人物
 */
public class HanFeiZi implements IHanFeiZi {

    /**韩非子是否再吃饭， 作为监控的标准*/
    private boolean isHaveBreakfast = false;

    /**韩非子是否在娱乐*/
    private boolean isHaveFun = false;

    /**吃饭了...*/
    @Override
    public void haveBreakfast() {
        System.out.println("韩非子要吃早饭了...");
        this.isHaveBreakfast = true;
    }

    /**韩非子开始娱乐了, 古代人没啥娱乐, 你能想到的就那么多...*/
    @Override
    public void haveFun() {
        System.out.println("韩非子开始娱乐了....");
        this.isHaveFun = false;
    }

    public boolean getIsHaveBreakfast() {
        return isHaveBreakfast;
    }

    public void setIsHaveBreakfast(boolean isHaveBreakfast) {
        this.isHaveBreakfast = isHaveBreakfast;
    }

    public boolean getIsHaveFun() {
        return isHaveFun;
    }

    public void setIsHaveFun(boolean isHaveFun) {
        this.isHaveFun = isHaveFun;
    }
}
