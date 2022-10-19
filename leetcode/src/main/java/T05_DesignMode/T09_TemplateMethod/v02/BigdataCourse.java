package T05_DesignMode.T09_TemplateMethod.v02;

/**
 * @author hx1098
 * @version 1.0.0
 * @createTime 2022/10/18 17:22
 * @description
 * @editUser hx1098
 * @editTime 2022/10/18 17:22
 * @editDescription
 */
public class BigdataCourse extends NetWorkCourse{


    private boolean needHomeWorkFlag = false;



    public BigdataCourse(boolean needHomeWorkFlag) {
        this.needHomeWorkFlag = needHomeWorkFlag;
    }

    @Override
    void checkHomeWork() {
        System.out.println("检查大数据的课件");
    }

    @Override
    protected boolean needWork() {
        return this.needHomeWorkFlag;
    }
}
