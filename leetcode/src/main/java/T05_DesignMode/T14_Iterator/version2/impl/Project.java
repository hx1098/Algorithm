package T05_DesignMode.T14_Iterator.version2.impl;

import T05_DesignMode.T14_Iterator.version2.IProject;
import T05_DesignMode.T14_Iterator.version2.IProjectIterator;

import java.util.ArrayList;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/10/18 16:41
 * @description
 * @editUser hx
 * @editTime 2021/10/18 16:41
 * @editDescription 所有项目的信息类
 */
public class Project implements IProject {

    /**定义一个项目列表, 所有的项目都放在这里*/
    private ArrayList<IProject> projectList = new ArrayList<>();

    /**项目名称*/
    private String name = "";

    /**项目成员数量*/
    private int num = 0;

    /**项目费用*/
    private int cost = 0;

    public Project() {
    }

    /**定义一个构造函数,将所有的老板需要看到的信息都存储起来*/
    public Project(String name, int num, int cost) {
        this.name = name;
        this.num = num;
        this.cost = cost;
    }

    /**增加项目*/
    @Override
    public void add(String name, int num, int cost) {
        this.projectList.add(new Project(name, num, cost));
    }

    /**获取项目信息*/
    @Override
    public String getProjectInfo() {
        String info = "";
        //获得项目的名称
        info = info+ "项目名称是：" + this.name;
        //获得项目人数
        info = info + "\t项目人数: "+ this.num;
        //项目费用
        info = info+ "\t 项目费用："+ this.cost;
        return info;
    }

    /**产生一个遍历对象.*/
    @Override
    public IProjectIterator iterator() {
        return new  ProjectIterator(this.projectList);
    }
}
