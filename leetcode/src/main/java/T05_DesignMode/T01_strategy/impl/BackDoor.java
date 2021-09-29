package T05_DesignMode.T01_strategy.impl;

/**
 * @author hx
 * @createTime 2021/9/29 15:22
 * @version 1.0.0
 * @description
 * @editUser hx
 * @editTime 2021/9/29 15:22
 * @editDescription 找乔国老帮忙,使孙权不能杀刘备
 */
public class BackDoor implements IStrategy{

    @Override
    public void operate() {
        System.out.println("去找乔国老帮忙,让吴国太给孙权市价压力...");
    }
}
