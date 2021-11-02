package T05_DesignMode.T21_Mediator.version2.impl;

import T05_DesignMode.T21_Mediator.version2.AbstractMediator;
import T05_DesignMode.T21_Mediator.version2.Purchase;
import T05_DesignMode.T21_Mediator.version2.Sale;
import T05_DesignMode.T21_Mediator.version2.Stock;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/11/2 13:28
 * @description
 * @editUser hx
 * @editTime 2021/11/2 13:28
 * @editDescription 具体的中介者, 中介者可以根据要求产生多个中介者, 一般情况下只有一个中介者, 划分各个中介者的职责
 */
public class Mediator extends AbstractMediator {

    public Mediator() {
        super();
    }

    /**
     * 中介者最终要的方法
     */
    @Override
    public void execute(String str, Object... objects) {
        /**采购电脑*/
        if (str.equals("purchase.buy")) {
            this.buyComputer((Integer) objects[0]);
        } else if (str.equals("sale.sell")) {//销售电脑
            this.sellComputer((Integer)objects[0]);
        } else if (str.equals("sale.offsell")) {//折价销售
            this.offSell();
        } else if (str.equals("stock.clear")){
            this.clearStock();
        }
    }

    /**
     * 采购电脑
     */
    private void buyComputer(int number) {
        //获取销售情况
        int saleStatus = super.sale.getSaleStatus();
        if (saleStatus > 80) {
            System.out.println("采购IBM电脑," + number + "台");
            super.stock.increase(number);
        } else {
            //    销售情况不好的情况
            int bugNumber = number / 2;
            System.out.println("采购IBM电脑" + bugNumber + "台");
        }
    }

    /**
     * 销售电脑
     */
    private void sellComputer(int num) {
        if (super.stock.getStockNumber() < num) {
            super.purchase.bugIbmComputer(num);
        }
        super.stock.decrease(num);
    }

    /**
     * 折价销售电脑
     */
    private void offSell() {
        System.out.println("折价销售电脑" + stock.getStockNumber() + "台");
    }

    private void clearStock() {
        //    要求清仓销售
        super.sale.offSale();
        //    要求采购人员不要进行采购
        super.purchase.refuseBuyIBM();
    }


   /* public Mediator(Purchase purchase, Sale sale, Stock stock) {
        super(purchase, sale, stock);
    }*/


}
