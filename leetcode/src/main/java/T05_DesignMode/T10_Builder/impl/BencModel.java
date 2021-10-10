package T05_DesignMode.T10_Builder.impl;

import T05_DesignMode.T10_Builder.CarModel;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/10/10 20:40
 * @description
 * @editUser hx
 * @editTime 2021/10/10 20:40
 * @editDescription 奔驰车一代的模型
 */
public class BencModel extends CarModel {


    @Override
    protected void start() {
        System.out.println("奔驰车启动时这个样子的.....");
    }

    @Override
    protected void stop() {
        System.out.println("奔驰车停止是这个的样子的.....");
    }

    @Override
    protected void alarm() {
        System.out.println("奔驰车的声音是这个样子的.....");
    }

    @Override
    protected void engineBoom() {
        System.out.println("奔驰车的引擎声音小的,,,,,,");
    }
}
