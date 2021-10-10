package T05_DesignMode.T09_TemplateMethod.extend;

import T05_DesignMode.T09_TemplateMethod.HummerModel;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/10/9 16:33
 * @description
 * @editUser hx
 * @editTime 2021/10/9 16:33
 * @editDescription H1和H2有什么差别，还真不知道，真没接触过悍马
 */
public class HummerH2Model extends HummerModel {


    /**启动了*/
    @Override
    public void start() {
        System.out.println("悍马H2启动....");
    }

    /**悍马停止了*/
    @Override
    public void stop() {
        System.out.println("悍马H2停止了...  ");
    }

    /**悍马朝你比比比叫...*/
    @Override
    public void alarm() {
        System.out.println("悍马H2鸣笛了....滴滴滴滴...");
    }

    /**悍马隆隆的声音叫*/
    @Override
    public void engineBoom() {
        System.out.println("悍马H2引擎声音是这样的....");
    }


}
