package T05_DesignMode.T21_Mediator.version2;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/11/2 10:13
 * @description
 * @editUser hx
 * @editTime 2021/11/2 10:13
 * @editDescription  AbstaractMediator 的作用是将这两个中介者的抽象定义, 定义了一个抽象方法execute,
 */
public abstract class AbstractMediator {

    protected Purchase purchase;
    protected Sale sale;
    protected Stock stock;

    public AbstractMediator() {
        purchase = new Purchase(this);
        sale = new Sale(this);
        stock = new Stock(this);
    }

    /**中介者最重要的方法,叫做事件方法, 处理多个对象之间的关系*/
    public abstract void execute(String str, Object... objects);

}
