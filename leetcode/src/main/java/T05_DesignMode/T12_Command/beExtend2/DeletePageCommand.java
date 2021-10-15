package T05_DesignMode.T12_Command.beExtend2;

import T05_DesignMode.T12_Command.Command;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/10/15 22:27
 * @description
 * @editUser hx
 * @editTime 2021/10/15 22:27
 * @editDescription 二代的实现 删除一个页面的需求
 */
public class DeletePageCommand extends Command {


    /**执行删除一个命令的需求*/
    @Override
    public void execute() {

        //找到前段页面项目组
        super.fg.find();
        //增加一个需求
        super.fg.add();
        //增加排期
        super.fg.plan();
    }
}
