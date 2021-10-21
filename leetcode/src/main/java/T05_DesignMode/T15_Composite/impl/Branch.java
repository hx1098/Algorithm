package T05_DesignMode.T15_Composite.impl;

import T05_DesignMode.T15_Composite.IBranch;
import T05_DesignMode.T15_Composite.ILeaf;

import java.util.ArrayList;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/10/21 17:29
 * @description
 * @editUser hx
 * @editTime 2021/10/21 17:29
 * @editDescription
 */
@SuppressWarnings("all")
public class Branch implements IBranch {

    /**存储子节点的信息*/
    private ArrayList sub = new ArrayList<String>();

    /**
     * 树枝节点的名称
     */
    private String name = "";

    /**树枝节点的职位*/
    private String position = "";

    /**树枝节点的薪水*/
    private int salary = 0;


    /**通过改造函数传递树枝节点的参数*/
    public Branch(String name, String position, int salary) {
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    /**添加一个子树枝节点*/
    @Override
    public void add(IBranch iBranch) {
        this.sub.add(iBranch);
    }

    /**添加一个叶子节点*/
    @Override
    public void add(ILeaf leaf) {
        this.sub.add(leaf);
    }

    /**获得自己树枝节点的信息*/
    @Override
    public ArrayList getSubordinateInfo() {
        return this.sub;
    }
    /***/
    @Override
    public String getInfo() {
        String info = "";
        info = "名称：" + this.name;
        info = info + "\t职位："+ this.position;
        info = info + "\t薪水："+this.salary;
        return info;
    }
}
