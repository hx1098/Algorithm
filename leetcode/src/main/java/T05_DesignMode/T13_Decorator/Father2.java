package T05_DesignMode.T13_Decorator;

import T05_DesignMode.T13_Decorator.extend.FouthGardSchoolReport;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/10/16 16:36
 * @description
 * @editUser hx
 * @editTime 2021/10/16 16:36
 * @editDescription 这是经过我的加工后, 老爸开始看我的成绩单.
 */
public class Father2 {
    public static void main(String[] args) {
        //把我经过美化后的成绩单唯唯诺诺的递了过去
        SchoolReport report = new FouthGardSchoolReport();

        //查看成绩
        report.report();

        //签名, 一看就这, 会心一笑, 签了名
        report.sign("老三");
    }
}
