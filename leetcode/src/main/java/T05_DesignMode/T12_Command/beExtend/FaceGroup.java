package T05_DesignMode.T12_Command.beExtend;

import T05_DesignMode.T12_Command.Group;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/10/13 22:28
 * @description
 * @editUser hx
 * @editTime 2021/10/13 22:28
 * @editDescription 美工组 职责:设计出一套漂亮, 简单的边界的页面
 */
public  class FaceGroup extends Group {


    /**首先你要找到美工组, 不然你谈个锤子锤子*/
    @Override
    public void find() {
        System.out.println("找到美工组....");
    }

    /**美工被要求增加一个页面*/
    @Override
    public void add() {
        System.out.println(" 客户要求增加一个页面.....");
    }

    /**甲方是老大, 被要求删除一些页面*/
    @Override
    public void delete() {
        System.out.println("客户要求删除一个页面....");
    }

    /**客户要求增肌一个功能*/
    @Override
    public void change() {
        System.out.println("客户要求修改一个页面...");
    }

    /**客户要求进行变更计划....*/
    @Override
    public void plan() {
        System.out.println("客户要求页面变更计划....");
    }
}
