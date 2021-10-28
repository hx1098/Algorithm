package T05_DesignMode.T18_Visitor.version1;

import T05_DesignMode.T18_Visitor.version1.impl.CommonEmploee;
import T05_DesignMode.T18_Visitor.version1.impl.ManagerEmploee;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/10/28 13:41
 * @description
 * @editUser hx
 * @editTime 2021/10/28 13:41
 * @editDescription
 */
public class Client {

    public static void main(String[] args) {
        for(Employee emp:mockEmployee()){
            emp.report();
        }
    }

    public static List<Employee> mockEmployee() {
        List<Employee> empList = new ArrayList<Employee>();
        //产生张三这个员工
        CommonEmploee zhangSan = new CommonEmploee();
        zhangSan.setJob("编写Java程序，绝对的蓝领、苦工加搬运工");
        zhangSan.setName("张三");
        zhangSan.setSalary(1800);
        zhangSan.setSex(Employee.MALE);
        empList.add(zhangSan);
        //产生李四这个员工
        CommonEmploee liSi = new CommonEmploee();
        liSi.setJob("页面美工，审美素质太不流行了！");
        liSi.setName("李四");
        liSi.setSalary(1900);
        liSi.setSex(Employee.FEMAILE);
        empList.add(liSi);
        //再产生一个经理
        ManagerEmploee wangWu = new ManagerEmploee();
        wangWu.setName("王五");
        wangWu.setPerformance("基本上是负值，但是我会拍马屁呀");
        wangWu.setSalary(18750);
        wangWu.setSex(Employee.MALE);
        empList.add(wangWu);
        return empList;
    }


}
