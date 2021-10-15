package T05_DesignMode.T12_Command.beExtend;

import T05_DesignMode.T12_Command.Group;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/10/13 22:34
 * @description
 * @editUser hx
 * @editTime 2021/10/13 22:34
 * @editDescription 代码组, 比较沉闷, 闷骚型的都是,
 *  代码组实现业务逻辑,包括数据库设计啦...
 */
public  class CodeGroup extends Group {

    /**客户要求代码组和我们谈谈....*/
    @Override
    public void find() {
        System.out.println("找到代码组.....");
    }

    /**有加需求了...完犊子*/
    @Override
    public void add() {
        System.out.println("增加需求了, 写不完了.....");
    }

    /**客户要求这个功能要删除掉...*/
    @Override
    public void delete() {
        System.out.println("客户要求删除掉一些功能....");
    }

    /**用户要求要改掉一些功能...*/
    @Override
    public void change() {
        System.out.println("用户要求要改掉一些功能....");
    }

    /**客户提出便更计划...*/
    @Override
    public void plan() {
        System.out.println("客户要求代码变更计划...");
    }
}
