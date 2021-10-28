package T05_DesignMode.T18_Visitor.version1.impl;

import T05_DesignMode.T18_Visitor.version1.Employee;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/10/28 13:35
 * @description 管理层的实现
 * @editUser hx
 * @editTime 2021/10/28 13:35
 * @editDescription 管理层的实现
 */
public class ManagerEmploee extends Employee {

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
    protected String getOtherInfo() {
        return "工作:　" + this.performance + "\t";
    }
}
