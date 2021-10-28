package T05_DesignMode.T18_Visitor.version2;

import T05_DesignMode.T18_Visitor.version2.impl.CommonEmployee;
import T05_DesignMode.T18_Visitor.version2.impl.ManagerEmployee;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/10/28 13:50
 * @description
 * @editUser hx
 * @editTime 2021/10/28 13:50
 * @editDescription 设计一个访问者接口
 */
public interface IVisitor {

    /**定义一个可以进行访问普通员工的接口*/
    public void visit(CommonEmployee commonEmployee);


    /**还要定义一个可以访问管理者的接口*/
    public void visit(ManagerEmployee managerEmployee);



}
