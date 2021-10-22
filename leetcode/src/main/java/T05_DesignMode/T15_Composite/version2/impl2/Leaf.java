package T05_DesignMode.T15_Composite.version2.impl2;

import T05_DesignMode.T15_Composite.version2.Corp;
import T05_DesignMode.T15_Composite.version2.ICorp;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/10/22 14:03
 * @description
 * @editUser hx
 * @editTime 2021/10/22 14:03
 * @editDescription
 */
@SuppressWarnings("all")
public class Leaf extends Corp {


    /**
     * 就写一个构造函数，这个是必须的
     */
    public Leaf(String _name, String _position, int _salary) {
        super(_name, _position, _salary);
    }

    @Override
    public String getInfo() {
        return super.getInfo();
    }
}
