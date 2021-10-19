package T05_DesignMode.T14_Iterator.version1;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/10/18 14:39
 * @description
 * @editUser hx
 * @editTime 2021/10/18 14:39
 * @editDescription 迭代器模式, 定义一个接口, 所有的项目都是一个接口.
 */
public interface IProject {

    /**老板就是从这里看到的就是项目的信息*/
    public String getPorjectInfo();
}
