package T05_DesignMode.T11_Bridge;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/10/11 9:30
 * @description
 * @editUser hx
 * @editTime 2021/10/11 9:30
 * @editDescription 桥梁模式 定义一个公司的抽象类
 */
public abstract class Corp {

    /**是公司就应该有生产的东西,不管是软件公司还是制造公司,,每个公司生产的东西都不一样,所以由实现类来完成*/
    protected abstract void produce();

    /**公司有产品了, 就应该有销售啊*/
    protected abstract void sell();

    protected  void makeMoney(){

        /**每个公司都一样, 先生产*/
        this.produce();

        /**然后销售*/
        this.sell();
    }




}
