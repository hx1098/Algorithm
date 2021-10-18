package T05_DesignMode.T13_Decorator;

import T05_DesignMode.T13_Decorator.extend.FouthGardSchoolReport;
import T05_DesignMode.T13_Decorator.extend2.HighScoreDecorator;
import T05_DesignMode.T13_Decorator.extend2.SortDecorator;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/10/16 16:36
 * @description
 * @editUser hx
 * @editTime 2021/10/16 16:36
 * @editDescription 这是经过我的加工后, 第三次看我的成绩单了
 */
public class Father3 {
    public static void main(String[] args) {
        //把我经过美化后的成绩单唯唯诺诺的递了过去
        SchoolReport report = null;
        //原装的成绩单
        report = new FouthGardSchoolReport();

        //将原装的成绩单加了一个最高分的说明
        report = new HighScoreDecorator(report);

        //又加了成绩排名的说明
        report = new SortDecorator(report);

        //查看成绩
        report.report();

        //签名, 一看就这, 会心一笑, 签了名
        report.sign("老三");
    }
}
