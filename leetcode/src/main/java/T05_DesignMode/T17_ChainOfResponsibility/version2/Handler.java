package T05_DesignMode.T17_ChainOfResponsibility.version2;


import sun.java2d.opengl.WGLSurfaceData;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/10/25 15:16
 * @description
 * @editUser hx
 * @editTime 2021/10/25 15:16
 * @editDescription 有处理权利的人员接口
 */
public abstract class Handler {

    /**处理的级别 儿子*/
    public static final int SON_LEVEL_REQUEST = 3;
    /**处理的级别 父亲*/
    public static final int FATHER_LEVEL_REQUEST = 1;
    /**处理的级别  丈夫*/
    public static final int HUSBAND_LEVEL_REQUEST = 2;

    /**能处理的级别*/
    private int level = 0;
    /**责任传递, 下一个责任人事谁*/
    private Handler nextHandler;
    /**每一个类都说明一下自己呢个处理那些请求*/
    public Handler(int level) {
        this.level = level;
    }


    /**有请示了,当然要回应一下子才行*/
    protected abstract void response(IWomen women);

    public final void HandleMessage(IWomen women) {
        //  如果当钱的请示 是有
        if (women.getType() == this.level) {
            this.response(women);
        } else {
            if (this.nextHandler != null) {
                this.nextHandler.HandleMessage(women);
            } else {
                System.out.println("没有地方请示了, 不同意....");
            }
        }
    }

    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }
}
