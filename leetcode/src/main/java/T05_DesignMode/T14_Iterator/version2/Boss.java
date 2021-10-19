package T05_DesignMode.T14_Iterator.version2;

import T05_DesignMode.T14_Iterator.version2.IProject;
import T05_DesignMode.T14_Iterator.version2.impl.Project;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/10/19 7:07
 * @description
 * @editUser hx
 * @editTime 2021/10/19 7:07
 * @editDescription 老板来查看项目对象了
 */
public class Boss {

    public static void main(String[] args) {

        ArrayList<IProject> projectList = new ArrayList<>();
        //增加星球大战项目
        projectList.add(new T05_DesignMode.T14_Iterator.version2.impl.Project("星球大战项目", 10, 100000));
        //增加扭转时空项目
        projectList.add(new T05_DesignMode.T14_Iterator.version2.impl.Project("扭转时空项目", 100, 10000000));
        //增加超人改造项目
        projectList.add(new T05_DesignMode.T14_Iterator.version2.impl.Project("超人改造项目", 10000, 1000000000));

        //这边100个项目
        for (int i = 4; i < 104; i++) {
            projectList.add(new Project("第" + i + "个项目", i * 5, i * 1000000));
        }
        Iterator<IProject> iterator = projectList.iterator();
        while (iterator.hasNext()) {
            IProject next = iterator.next();
            System.out.println(next.getProjectInfo());
        }


    }


}
