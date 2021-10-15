package T05_DesignMode.T12_Command;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/10/15 22:32
 * @description
 * @editUser hx
 * @editTime 2021/10/15 22:32
 * @editDescription 接头人, 接受命令的人,  职责就是接受命令, 并执行
 */
public class Invoke {

    /**命令*/
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    /**子类会通过调用action方法类执行命令, 只用传入特定的命令就可以了.*/
    public void action() {
        this.command.execute();
    }

}
