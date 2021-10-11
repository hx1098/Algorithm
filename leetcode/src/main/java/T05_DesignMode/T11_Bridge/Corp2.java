package T05_DesignMode.T11_Bridge;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/10/11 22:19
 * @description
 * @editUser hx
 * @editTime 2021/10/11 22:19
 * @editDescription 二代公司的结构..
 */
public class Corp2 {

    /**定义一个产品对象, 我也不知道是卖的啥,, 够抽象了吧*/
    private Product product;

    /**构造函数, 由子类的定义传递什么类型的产品*/
    public Corp2(Product product) {
        this.product = product;
    }

    /**公司是用来赚钱的*/
    public void makeMoney() {
        /**每个公司都一样, 先把产品生产出来*/
        this.product.beProducted();
        /**找销售人员来贩卖*/
        this.product.beSelled();
    }


}
