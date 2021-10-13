package T05_DesignMode.T12_Command.beExtend;

import T05_DesignMode.T12_Command.Group;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/10/13 22:24
 * @description
 * @editUser hx
 * @editTime 2021/10/13 22:24
 * @editDescription 需求组  职责是和客户进行沟通,这个组的人都是业务领域的专家
 */
public class RequirementGroup extends Group {


    /**客户要求需求组过去和他们谈*/
    @Override
    public void find() {
        System.out.println("找到需求组....");
    }

    /**客户增加一个需求*/
    @Override
    public void add() {
        System.out.println("客户要求增加一项需求...");
    }

    /**客户要求删除一项需求*/
    @Override
    public void delete() {
        System.out.println("客户要求删除一项需求....");
    }

    /**客户要求修改一项需求*/
    @Override
    public void change() {
        System.out.println("客户要求修改一项需求...");
    }

    /**客户要求出变更计划*/
    @Override
    public void plan() {
        System.out.println("你就进行排期吧....哈哈哈我下班了..");
    }
}
