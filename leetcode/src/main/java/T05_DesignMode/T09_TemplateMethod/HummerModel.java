package T05_DesignMode.T09_TemplateMethod;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/10/9 16:26
 * @description
 * @editUser hx
 * @editTime 2021/10/9 16:26
 * @editDescription 造车的悍马模型, 我先把这个模型给制造出来, 后期H1 H2在出升级款
 */
public abstract class HummerModel {

    /**首先这个悍马的模型要能运行起来, 不管是手摇发送还是电动,, 反正就是要启动起来, 那这个实现就会在实现类里面*/
    public abstract void start();

    /**能发动,那还要能停下来, 那才是真本事*/
    public abstract void stop();

    /**还得有喇叭的声音*/
    public abstract void alarm();

    /**引擎会响有声音就可以了, 能跑就行*/
    public abstract void engineBoom();

    /**最后这个模型一定是要能跑的, 不能跑我要他干嘛的*/
    public void run(){
        //  先发动汽车
        this.start();
        //  引擎开始轰鸣
        this.engineBoom();
        //  喇叭乱叫
        this.alarm();
        //  悍马停车了, 下来了一个美女
        this.stop();
    }
}
