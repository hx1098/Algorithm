package T05_DesignMode.T21_Mediator.version1;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/11/2 9:44
 * @description
 * @editUser hx
 * @editTime 2021/11/2 9:44
 * @editDescription client
 */
public class Client {
    public static void main(String[] args) {

        //    采购人员采购电脑
        System.out.println("\n---------采购人员采购电脑-----------");
        Purchase purchase = new Purchase();
        purchase.bugIbmComputer(100);

        //    销售人员销售电脑
        System.out.println("\n--------销售人员销售电脑--------");
        Sale sale = new Sale();
        sale.sellIBMComputer(1);

        //    库房人员管理库存
        System.out.println("\n------库房人员管理库存--------");
        Stock stock = new Stock();
        stock.cleatStock();
    }

}
