package T05_DesignMode.T15_Composite.version2.impl2;

import T05_DesignMode.T15_Composite.version2.Corp;
import T05_DesignMode.T15_Composite.version2.IBranch;
import T05_DesignMode.T15_Composite.version2.ICorp;

import java.util.ArrayList;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/10/22 14:12
 * @description
 * @editUser hx
 * @editTime 2021/10/22 14:12
 * @editDescription 这些树枝节点(经理) 纪要有自己的信息, 还需要有自己下属员工的信息
 */
public class Branch extends Corp {


    /**领导下边有哪些下级领导和小兵*/
    ArrayList<Corp> sub = new ArrayList<>();


    public Branch(String _name, String _position, int _salary) {
        super(_name, _position, _salary);
    }


    /**增加一个下属, 也可能是小兵*/
    public void addSubordinate(Corp corp) {
        this.sub.add(corp);
    }


    /**我有哪些下属*/
    public ArrayList<Corp> getSubordinate() {
        return this.sub;
    }

}
