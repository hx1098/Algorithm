package T05_DesignMode.T13_Decorator.extend;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/10/16 16:42
 * @description
 * @editUser hx
 * @editTime 2021/10/16 16:42
 * @editDescription 我一看成绩, 我去, 这回家不得一顿男女混合打, 屁股要开花了,  我还是美化一下成绩再回家禀告父王吧,
 */
public class SugarFouthGardSchoolReport extends FouthGardSchoolReport {

    /**
     * 首先要顶一你美化的一些方法,先给老爸说学校的最高成绩
     */
    private void reportHighScore() {
        System.out.println("此次考试语文最高成绩是75,数学是78,自然是80");
    }

    /**在父皇看完成绩单之后, 我在汇报学校的排名情况*/
    private void reportSort() {
        System.out.println("我的排名是第三十八名.....");
    }


    @Override
    public void report() {
        //先说最高成绩
        this.reportHighScore();
        //然后老板看成绩单
        super.report();
        //报告父皇我的私塾的排名....
        this.reportSort();
    }
}
