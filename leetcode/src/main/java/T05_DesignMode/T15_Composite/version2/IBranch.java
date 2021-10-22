package T05_DesignMode.T15_Composite.version2;

import java.util.ArrayList;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/10/22 14:08
 * @description
 * @editUser hx
 * @editTime 2021/10/22 14:08
 * @editDescription 这些下面有小兵的或者经理的风云人物
 */
public interface IBranch {

    /**能够增加小兵(树叶节点), 或者是经理 (树枝节点)*/
    public void addSubordinate(ICorp corp);


    /**我还要能够获取下属的信息*/
    public ArrayList<ICorp> getSubordinate();





}
