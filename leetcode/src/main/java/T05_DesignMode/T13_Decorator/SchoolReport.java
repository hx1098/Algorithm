package T05_DesignMode.T13_Decorator;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/10/16 16:02
 * @description
 * @editUser hx
 * @editTime 2021/10/16 16:02
 * @editDescription 成绩单的抽象类
 */
public abstract class SchoolReport {

    /**成绩单主要展示的就是你的成绩状况*/
    public abstract void report();

    /**成绩单要家长签字, 这是最令人头疼的*/
    public abstract void sign(String name);



}
