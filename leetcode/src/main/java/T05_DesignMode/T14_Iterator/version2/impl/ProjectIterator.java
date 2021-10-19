package T05_DesignMode.T14_Iterator.version2.impl;

import T05_DesignMode.T14_Iterator.version2.IProject;
import T05_DesignMode.T14_Iterator.version2.IProjectIterator;

import java.util.ArrayList;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/10/18 17:12
 * @description
 * @editUser hx
 * @editTime 2021/10/18 17:12
 * @editDescription
 */
public class ProjectIterator implements IProjectIterator {


    /**
     * 所有项目都放在arrayList当中
     */
    private ArrayList<IProject> projectArrayList = new ArrayList<>();

    /**用来判断当前的list是否是0*/
    private int currentItem = 0;

    /**
     * 构造函数传入projectList
     */
    public ProjectIterator(ArrayList<IProject> projectArrayList) {
        this.projectArrayList = projectArrayList;
    }

    /**判断是否还有元素, 必须实现*/
    @Override
    public boolean hasNext() {
        Boolean b = true;
        if (this.currentItem >= projectArrayList.size() ||
                this.projectArrayList.get(this.currentItem) == null) {
            b = false;
        }
        return b;
    }

    /**获取下一个值*/
    @Override
    public  IProject next() {
        return (IProject) this.projectArrayList.get(this.currentItem++);
    }

    /**删除一个对象, 暂时没有使用到 */
    @Override
    public void remove() {

    }
}
