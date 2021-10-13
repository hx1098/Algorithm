package T05_DesignMode.T12_Command;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/10/13 22:19
 * @description
 * @editUser hx
 * @editTime 2021/10/13 22:19
 * @editDescription 项目分为三个组, 每个组都要进行增删改查的命令
 */
public abstract class Group {

    /**
     * 甲乙双方分开办公,你要和哪个组讨论,你首先要找到这个组
     */
    public abstract void find();

    /**
     * 被要求增加功能
     */
    public abstract void add();

    /**
     * 被要求删除功能
     */
    public abstract void delete();

    /**
     * 被要求修改功能
     */
    public abstract void change();

    /**
     * 被要求给出所有的变更计划
     */
    public abstract void plan();

}
