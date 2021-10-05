package T05_DesignMode.T05_FactoryMethod.Impl;

import T05_DesignMode.T05_FactoryMethod.Human;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/10/5 9:26
 * @description 黄种人
 * @editUser hx
 * @editTime 2021/10/5 9:26
 * @editDescription 首先定义一个具体的人类
 */
public class YellowHuman implements Human {

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
}
