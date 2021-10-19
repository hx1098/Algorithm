package T05_DesignMode.T14_Iterator.version1;

import java.util.ArrayList;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/10/18 15:25
 * @description
 * @editUser hx
 * @editTime 2021/10/18 15:25
 * @editDescription 老板来看项目信息了
 */
public class Boss {
    public static void main(String[] args) {

        ArrayList<IProject> projectList = new ArrayList<>();
        //增加星球大战项目
        projectList.add(new Project("星球大战项目",10,100000));
        //增加扭转时空项目
        projectList.add(new Project("扭转时空项目",100,10000000));
        //增加超人改造项目
        projectList.add(new Project("超人改造项目",10000,1000000000));

        //这边100个项目
        for(int i=4;i<104;i++){
            projectList.add(new Project("第"+i+"个项目",i*5,i*1000000));
        }

        //遍历一下ArrayList，把所有的数据都取出
        for(IProject project:projectList){
            System.out.println(project.getPorjectInfo());
        }
    }
}
