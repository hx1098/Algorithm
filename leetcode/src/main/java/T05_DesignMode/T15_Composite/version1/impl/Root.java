package T05_DesignMode.T15_Composite.version1.impl;

import T05_DesignMode.T15_Composite.version1.IBranch;
import T05_DesignMode.T15_Composite.version1.ILeaf;
import T05_DesignMode.T15_Composite.version1.IRoot;

import java.util.ArrayList;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/10/19 10:38
 * @description
 * @editUser hx
 * @editTime 2021/10/19 10:38
 * @editDescription 根节点的实现类
 */
public class Root implements IRoot {

    /**保存跟节点一下的树枝节点和树叶节点,sbu的意思是下级*/
    private ArrayList sub = new ArrayList<String>();

    /**根节点名称*/
    private String name = "";

    /**根节点的职位*/
    private String position = "";

    /**根节点的薪水*/
    private int salary = 0;

    /**通过构造函数传递进来总经理的信息*/
    public Root(String name, String position, int salary) {
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    /**得到自己的信息*/
    @Override
    public String getInfo() {
        String info = "";
        info = "名称" + this.name;
        info = "职位" + this.position;
        info = "\n薪水" + this.salary;
        return info;
    }

    /**增加树枝节点*/
    @Override
    public void add(IBranch branch) {
        this.sub.add(branch);
    }

    /**增加叶子节点，比如秘书，直接隶属总经理*/
    @Override
    public void add(ILeaf leaf) {
        this.sub.add(leaf);
    }

    /**得到下级的信息*/
    @Override
    public ArrayList getSubordinateInfo() {
        return this.sub;
    }

}
