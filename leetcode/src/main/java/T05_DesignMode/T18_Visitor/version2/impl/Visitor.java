package T05_DesignMode.T18_Visitor.version2.impl;

import T05_DesignMode.T18_Visitor.version2.Employee;
import T05_DesignMode.T18_Visitor.version2.IVisitor;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/10/28 13:53
 * @description
 * @editUser hx
 * @editTime 2021/10/28 13:53
 * @editDescription  既可以进行访问普通员工, 又可以访问管理者的接口实现类
 */
public class Visitor implements IVisitor {

    /**访问普通员工, 打印出报表*/
    @Override
    public void visit(CommonEmployee commonEmployee) {
        System.out.println(this.getCommonEmployeel(commonEmployee));
    }

    /**访问管理者, 打印出报表*/
    @Override
    public void visit(ManagerEmployee managerEmployee) {
        System.out.println(this.getManagerEmployeel(managerEmployee));
    }



    /**组装出部门关经理的信息*/
    private String getManagerEmployeel(ManagerEmployee managerEmployee) {
        String basicInfo = this.getBasicInfo(managerEmployee);
        String otherInfo = managerEmployee.getPerformance();
        return basicInfo + otherInfo;
    }

    /**组装出普通员工信息*/
    private String getCommonEmployeel(CommonEmployee commonEmployee) {
        String basicInfo = this.getBasicInfo(commonEmployee);
        String otherInfo = "工作: "+  commonEmployee.getJob();
        return basicInfo + otherInfo;
    }

    private String getBasicInfo(Employee employee) {
        String info = "姓名：" + employee.getName() + "\t";
        info = info + "性别：" + (employee.getSex() == Employee.FEMAILE?"女":"男") + "\t";
        info = info + "薪水：" + employee.getSalary() + "\t";
        return info;
    }
}
