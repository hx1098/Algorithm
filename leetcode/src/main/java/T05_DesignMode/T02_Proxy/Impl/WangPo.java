package T05_DesignMode.T02_Proxy.Impl;

import T05_DesignMode.T02_Proxy.KindWomen;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/9/29 16:38
 * @description
 * @editUser hx
 * @editTime 2021/9/29 16:38
 * @editDescription 王婆这个人是个老江湖了, 非常聪明,但是男人们都看不上她,
 * 但是她有社会经验啊, 深谙世事, 让她做为一个女人的代理最合适不过了.
 */
public class WangPo implements KindWomen {

    private KindWomen kindWomen;

    /**王婆默认是潘金莲的代理*/
    public WangPo() {
        this.kindWomen = new PanJinLian();
    }

    /**王婆家里不能只有一个潘金莲啊, 不然客人来了还需要排队, 所以她还可以代理除潘金莲之外的人*/
    public WangPo(KindWomen kindWomen) {
        this.kindWomen = kindWomen;
    }

    @Override
    public void makeEyesWithMan() {
        this.kindWomen.makeEyesWithMan();//王婆年纪大了, 谁看她抛媚眼呀!
    }

    @Override
    public void happyWithMan() {
        this.kindWomen.happyWithMan();//王婆年纪老了, 自己干不了, 让年轻的代替吧...
    }
}
