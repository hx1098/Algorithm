package T05_DesignMode.T12_Command;

import T05_DesignMode.T12_Command.beExtend.RequirementGroup;
import T05_DesignMode.T12_Command.beExtend2.AddRequirementCommand;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/10/15 21:53
 * @description
 * @editUser hx
 * @editTime 2021/10/15 21:53
 * @editDescription 客户是孙子, 我们是爷爷, 孙子要啥, 老子就给啥
 */
public class Client2 {

    public static void main(String[] args) {

        System.out.println("定义我们的接头人...");
        Invoke sange = new Invoke();

        System.out.println("------------客户增加一项命令需求--------------");
        //    客户给我们下命令来了
        Command command = new AddRequirementCommand();
        //三哥 去设置增加一个需求的命令
        sange.setCommand(command);
        //三哥 跑去项目组让他们执行去了.
        sange.action();
        //    三哥太强了, 啥都能干


    }

}
