package T05_DesignMode.T21_Mediator.version1;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/11/1 16:05
 * @description
 * @editUser hx
 * @editTime 2021/11/1 16:05
 * @editDescription 库存表
 */
public class Stock {

    /**刚开始有100太电脑*/
    private static int COMPUTER_NUM = 100;

    /**库存增加*/
    public void increase(int num) {
        COMPUTER_NUM = COMPUTER_NUM + num;
        System.out.println("库存数量为:" + COMPUTER_NUM);
    }

    /**库存减少*/
    public void decrease(int num) {
        COMPUTER_NUM = COMPUTER_NUM - num;
        System.out.println("库存数量为:" + COMPUTER_NUM);
    }

    /**获取库存数量*/
    public int getStockNumber() {
        return COMPUTER_NUM;
    }

    /**库存压力大了, 就要通知采购人员不要进行采购了, 需要进行尽快的销售了.*/
    public void cleatStock() {
        Purchase purchase = new Purchase();
        Sale sale = new Sale();
        System.out.println("清理存货数量为:" + COMPUTER_NUM);

        //要求进行折价进行销售
        sale.offSale();
        //要求采购人员不要在进行采购了
        purchase.refuseBuyIBM();

    }



}
