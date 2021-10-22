package T05_DesignMode.T15_Composite.version1.impl;

import T05_DesignMode.T15_Composite.version1.ILeaf;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/10/21 17:41
 * @description
 * @editUser hx
 * @editTime 2021/10/21 17:41
 * @editDescription
 */
@SuppressWarnings("all")
public class Leaf implements ILeaf {

    /**叫神魔名字*/
    private String name = "";

    /**叶子的职位*/
    private String position = "";

    /**叶子的薪水*/
    private int salary = 0;

    /**铜鼓构造函数传递信息*/
    public Leaf(String name, String position, int salary) {
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    /**最新的兵只能获得自己的信息*/
    @Override
    public String getInfo() {
        String info = "";
        info = "名称：" + this.name;
        info = info + "\t职位："+ this.position;
        info = info + "\t薪水："+this.salary;
        return info;
    }
}
