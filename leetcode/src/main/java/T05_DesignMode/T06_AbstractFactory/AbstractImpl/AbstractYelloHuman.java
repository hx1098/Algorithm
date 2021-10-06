package T05_DesignMode.T06_AbstractFactory.AbstractImpl;

import T05_DesignMode.T06_AbstractFactory.Human;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/10/5 9:26
 * @description 黄种人
 * @editUser hx
 * @editTime 2021/10/5 9:26
 * @editDescription 首先定义一个具体的人类
 */
public abstract class AbstractYelloHuman implements Human {

    @Override
    public void laugh() {
        System.out.println("黄种人会笑..");
    }

    @Override
    public void cry() {
        System.out.println("黄种人会哭..");
    }

    @Override
    public void talk() {
        System.out.println("黄种人会说中文...");
    }

    @Override
    public void sex() {

    }
}
