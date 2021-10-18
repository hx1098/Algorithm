package T05_DesignMode.T13_Decorator.extend2;

import T05_DesignMode.T13_Decorator.Decorator;
import T05_DesignMode.T13_Decorator.SchoolReport;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/10/16 17:15
 * @description
 * @editUser hx
 * @editTime 2021/10/16 17:15
 * @editDescription 学校的排名情况汇报
 */
public class SortDecorator extends Decorator {

    public SortDecorator(SchoolReport schoolReport) {
        super(schoolReport);
    }


    /**告诉老爸的学校排名情况*/
    private void reportSort() {
        System.out.println("我排名第38位...");
    }

    /**老爸看完成绩单后再告诉他, 加强作用*/
    @Override
    public void sign(String name) {
        super.report();
        this.reportSort();
    }
}
