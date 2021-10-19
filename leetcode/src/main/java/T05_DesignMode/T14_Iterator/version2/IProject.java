package T05_DesignMode.T14_Iterator.version2;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/10/18 16:35
 * @description
 * @editUser hx
 * @editTime 2021/10/18 16:35
 * @editDescription 定义一个接口, 所有的项目都欧式一个接口
 */
public interface IProject {

    /**增加项目*/
    public void add(String name, int num, int cost);

    /**从老板这里看到的就是项目信息*/
    public String getProjectInfo();

    /**获得一个可以遍历的对象*/
    public IProjectIterator iterator();


}
