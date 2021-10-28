package T05_DesignMode.T18_Visitor.version2.impl;

import T05_DesignMode.T18_Visitor.version2.Employee;
import T05_DesignMode.T18_Visitor.version2.IVisitor;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/10/28 13:35
 * @description 普通员工
 * @editUser hx
 * @editTime 2021/10/28 13:35
 * @editDescription 普通员工的实现
 */
public class CommonEmployee extends Employee {

    /**工作内容, 这个十分重要,以后置业规划就是靠他了*/
    private String job;

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    /**我允许访问这进行访问*/
    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }
}
