package T05_DesignMode.T13_Decorator.extend2;

import T05_DesignMode.T13_Decorator.Decorator;
import T05_DesignMode.T13_Decorator.SchoolReport;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/10/16 16:59
 * @description
 * @editUser hx
 * @editTime 2021/10/16 16:59
 * @editDescription  继承自装饰类,  我先要吧学校的最高成绩告诉老爸, 不然我指定屁股开花
 */
public class HighScoreDecorator extends Decorator {

    /**构造函数*/
    public HighScoreDecorator(SchoolReport schoolReport) {
        super(schoolReport);
    }

    /**先汇报最高成绩..*/
    private void reportHighScore() {
        System.out.println("这次考试语文最高是75，数学是78，自然是80");
    }

    /**最高成绩我要在老爸看成绩单之前告诉他, 否则等他一看, 准那笤帚打我了, 我哪里还有机会说了*/
    @Override
    public void report() {
        this.reportHighScore();
        super.report();
    }



}
