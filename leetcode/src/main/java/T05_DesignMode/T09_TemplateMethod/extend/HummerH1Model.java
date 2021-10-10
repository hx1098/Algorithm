package T05_DesignMode.T09_TemplateMethod.extend;

import T05_DesignMode.T09_TemplateMethod.HummerModel;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/10/9 16:33
 * @description
 * @editUser hx
 * @editTime 2021/10/9 16:33
 * @editDescription 悍马车是每个越野者的喜爱的, 其中H1是最接近军用系列的
 */
public class HummerH1Model extends HummerModel {


    /**启动了*/
    @Override
    public void start() {
        System.out.println("悍马H1启动....");
    }

    /**悍马停止了*/
    @Override
    public void stop() {
        System.out.println("悍马H1停止了...  ");
    }

    /**悍马朝你比比比叫...*/
    @Override
    public void alarm() {
        System.out.println("悍马H1鸣笛了....滴滴滴滴...");
    }

    /**悍马隆隆的声音叫*/
    @Override
    public void engineBoom() {
        System.out.println("悍马H1引擎声音是这样的....");
    }


}
