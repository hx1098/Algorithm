package T05_DesignMode.T13_Decorator;

import T05_DesignMode.T13_Decorator.extend.FouthGardSchoolReport;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/10/16 16:36
 * @description
 * @editUser hx
 * @editTime 2021/10/16 16:36
 * @editDescription 老爸开始看成绩单了.
 */
public class Father {
    public static void main(String[] args) {
        //四年级的成绩单拿来吧你
        SchoolReport report = new FouthGardSchoolReport();

        //查看成绩
        report.report();

        //签名, 一看就这, 不签名了
        //report.sign();
    }
}
