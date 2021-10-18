package T05_DesignMode.T13_Decorator;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/10/16 16:54
 * @description
 * @editUser hx
 * @editTime 2021/10/16 16:54
 * @editDescription 装饰类, 我要把我的成绩单装饰一下
 */
public abstract class Decorator extends SchoolReport{

    /**首先我要知道是哪个成绩单, 以后可能会有五年级的, 初中的, 高中的.*/
    private SchoolReport schoolReport;

    public Decorator(SchoolReport schoolReport) {
        this.schoolReport = schoolReport;
    }

    /**查看成绩单*/
    @Override
    public void report() {
        this.schoolReport.report();
    }

    /**查看完趁成绩单还是看看是否能够签名呢的*/
    @Override
    public void sign(String name) {
        this.schoolReport.sign(name);
    }
}
