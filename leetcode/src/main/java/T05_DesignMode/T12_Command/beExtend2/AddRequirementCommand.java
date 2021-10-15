package T05_DesignMode.T12_Command.beExtend2;

import T05_DesignMode.T12_Command.Command;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/10/15 22:23
 * @description
 * @editUser hx
 * @editTime 2021/10/15 22:23
 * @editDescription 二代的实现  增加一项需求
 */
public class AddRequirementCommand extends Command {


    /**
     * 执行增加一项需求的命令
     */
    @Override
    public void execute() {
        //找到需求组
        super.rg.find();
        //增加一个需求
        super.rg.add();
        //给出计划,增加排期
        super.rg.plan();
    }
}
