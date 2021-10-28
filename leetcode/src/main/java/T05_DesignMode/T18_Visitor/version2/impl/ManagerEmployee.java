package T05_DesignMode.T18_Visitor.version2.impl;

import T05_DesignMode.T18_Visitor.version2.Employee;
import T05_DesignMode.T18_Visitor.version2.IVisitor;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/10/28 13:35
 * @description 管理层的实现
 * @editUser hx
 * @editTime 2021/10/28 13:35
 * @editDescription 管理层的实现
 */
public class ManagerEmployee extends Employee {

    /**这类人的职责就是： 业绩*/
    private String performance;

    public String getPerformance() {
        return performance;
    }

    public void setPerformance(String performance) {
        this.performance = performance;
    }

    /**返回这个管理人员的业绩*/
    @Override
    public  void accept(IVisitor visitor) {
        visitor.visit(this);
    }
}
