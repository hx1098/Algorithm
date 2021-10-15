package T05_DesignMode.T12_Command;

import T05_DesignMode.T12_Command.beExtend.CodeGroup;
import T05_DesignMode.T12_Command.beExtend.FaceGroup;
import T05_DesignMode.T12_Command.beExtend.RequirementGroup;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/10/15 22:17
 * @description
 * @editUser hx
 * @editTime 2021/10/15 22:17
 * @editDescription 定义一个命令的抽象类.我们吧客户发出的命令定义成一个个对象,
 *   command 类可以有很多的子类, 这里你只用往上增加就行了.
 */
public abstract class Command {

    //    把三个项目组都定义好, 子类都可以使用
    /**需求组*/
    protected RequirementGroup rg = new RequirementGroup();
    /**程序员组*/
    protected CodeGroup cg = new CodeGroup();
    /**美工组*/
    protected FaceGroup fg = new FaceGroup();
    /**只要一个方法， 就是传入你要我做的事情就行了*/
    public abstract void execute();

}
