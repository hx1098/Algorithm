package T05_DesignMode.T15_Composite.version1;

import java.util.ArrayList;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/10/19 10:34
 * @description
 * @editUser hx
 * @editTime 2021/10/19 10:34
 * @editDescription 树枝节点, 也就是各个部门的经理和组长的角色
 */
public interface IBranch {

    /**获得信息*/
    public String getInfo();

    /**增加数据节点, 例如研发部门的研发一组*/
    public void add(IBranch iBranch);

    /**增加叶子节点*/
    public void add(ILeaf leaf);

    /**获得下级信息*/
    public ArrayList getSubordinateInfo();



}
