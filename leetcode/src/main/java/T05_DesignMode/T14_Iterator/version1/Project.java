package T05_DesignMode.T14_Iterator.version1;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/10/18 14:41
 * @description  第一版的给老板看项目报表,不是迭代器模式.
 * @editUser hx
 * @editTime 2021/10/18 14:41
 * @editDescription 所有项目的信息类 直接实现所有接口,
 */
public class Project implements IProject {


    /**
     * 项目名称
     */
    private String name;

    /**
     * 项目成员数量
     */
    private int count = 0;

    /**
     * 项目费用
     */
    private int cost = 0;


    /**
     * 定义一个构造函数, 将老板所有能看到的信息存储起来
     */
    public Project(String name, int count, int cost) {
        this.name = name;
        this.count = count;
        this.cost = cost;
    }

    /**
     * 得到项目信息
     */
    @Override
    public String getPorjectInfo() {
        String info = "";
        //获得项目的信息
        info = info + "项目名称是:　" + this.name;
        info = info + "\t项目的人数: " + this.count;
        info = info + "\t项目费用: " + this.cost;
        return info;
    }
}
