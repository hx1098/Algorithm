package T05_DesignMode.T06_AbstractFactory;

import T05_DesignMode.T05_FactoryMethod.ClassUtils;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/10/6 20:48
 * @description
 * @editUser hx
 * @editTime 2021/10/6 20:48
 * @editDescription 编写一个抽象类, 根绝Enum, 创建一个人类出来
 */
public abstract class AbstractHumanFactory implements HumanFactory {

    protected Human createHuman(HumanEnum humanEnum) {
        Human human = null;
        //    如果传过来的不是Enmu中具体的一个emlement的话,则不做处理
        if (!humanEnum.getValue().equals("")) {
            try {
                human = (Human) Class.forName(humanEnum.getValue()).newInstance();
            } catch (Exception e) {
                //      因为使用了enmu,这种情况就不会产生了,除非你的enum有问题
                e.printStackTrace();
            }
        }
        return human;
    }



}
