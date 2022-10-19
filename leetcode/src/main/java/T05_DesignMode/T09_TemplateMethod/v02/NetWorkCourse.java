package T05_DesignMode.T09_TemplateMethod.v02;

/**
 * @author hx1098
 * @version 1.0.0
 * @createTime 2022/10/18 17:01
 * @description
 * @editUser hx1098
 * @editTime 2022/10/18 17:01
 * @editDescription 模版会有一个或多个未实现的方法，而且这几个未实现的方法有固定的执行顺序
 */
public abstract class NetWorkCourse {

    public final void createCourse() {

        //发布预习资料
        this.postPreResources();
        //制作ppt课件
        this.createPPT();
        //在线直播
        this.liveVideo();
        //提交笔记
        this.postNote();
        //提交源码
        this.postSources();
        //布置作业，有些课程是没有作业，有些课程是有作业的
        //如果有作业检查作业，如果没有作业，流程结束
        if (needWork()) {
            checkHomeWork();
        }
    }


    abstract void checkHomeWork();

    /**钩子函数，实现流程微调*/
    protected boolean needWork() {
        return false;
    }

    private void postSources() {
        System.out.println("提交源代码");
    }

    private void postNote() {
        System.out.println("提交笔记");
    }

    private void liveVideo() {
        System.out.println("直播");
    }

    private void createPPT() {
        System.out.println("创建备课ppt");
    }

    private void postPreResources() {
        System.out.println("分发预习资料");
    }


}
