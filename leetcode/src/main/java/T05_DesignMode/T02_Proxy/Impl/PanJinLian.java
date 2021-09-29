package T05_DesignMode.T02_Proxy.Impl;

import T05_DesignMode.T02_Proxy.KindWomen;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/9/29 16:35
 * @description 定义潘金莲是一个神魔样的人...
 * @editUser hx
 * @editTime 2021/9/29 16:35
 * @editDescription
 */
public class PanJinLian implements KindWomen {

    @Override
    public void makeEyesWithMan() {
        System.out.println("潘金莲抛媚眼...");
    }

    @Override
    public void happyWithMan() {
        System.out.println("潘金莲在和那个人做那个...");
    }
}
