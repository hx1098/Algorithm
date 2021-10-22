package T05_DesignMode.T15_Composite.version2;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/10/22 11:04
 * @description
 * @editUser hx
 * @editTime 2021/10/22 11:04
 * @editDescription 公司类， 定义每个与员工都有的信息
 */
public interface ICorp {

    /**
     * 每个员工的都有的信息, 你想隐藏, 没门
     */
    public String getInfo();


}
