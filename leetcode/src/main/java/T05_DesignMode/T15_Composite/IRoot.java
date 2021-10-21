package T05_DesignMode.T15_Composite;

import java.util.ArrayList;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/10/19 10:31
 * @description
 * @editUser hx
 * @editTime 2021/10/19 10:31
 * @editDescription 总经理, 根节点,
 */
public interface IRoot {

    /**
     * 得到总经理的信息
     */
    public String getInfo();

    /**
     * 总经理下面要有小兵,要增加小兵,比如研发部总经理,这个就是树枝节点
     */
    public void add(IBranch branch);

    /**
     * 那要增加树叶节点
     */
    public void add(ILeaf leaf);

    /**
     * 既然要增加, 那还要能够遍历,不可能总经理不知道自己手下有多少人
     */
    public ArrayList getSubordinateInfo();


}
