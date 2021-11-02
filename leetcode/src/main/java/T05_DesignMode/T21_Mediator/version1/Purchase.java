package T05_DesignMode.T21_Mediator.version1;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/11/1 16:01
 * @description
 * @editUser hx
 * @editTime 2021/11/1 16:01
 * @editDescription 采购ibm型号的电脑
 *  总的来说, Purchase 定义了采购电脑的一个标准
 *  如果销售情况好, 你让我采购多少就可以,
 *  如果销售情况不好情况下, 我就采购五十台, 对折进行采购,
 *  电脑采购完毕了, 肯定要放到库房中的, 因此要调用库存的方法, 增加库存电脑的数量.
 */
public class Purchase {


    /**
     * 采购IBM型号的电脑
     */
    public void bugIbmComputer(int  number) {
        //访问库存
        Stock stock = new Stock();
        //    访问销售
        Sale sale = new Sale();


        /**查看电脑的销售情况*/
        int saleStatus = sale.getSaleStatus();

        if (saleStatus > 80) {
            System.out.println("采购IBM电脑," + number + "台");
        } else {//销售情况不好的时候
            //销售情况不好时候要进行折半进行采购
            int buyNumber = number / 2;
            System.out.println("采购IBM电脑," + buyNumber + "台");
        } 
    }


    /**不在采购IMB电脑*/
    public void refuseBuyIBM() {
        System.out.println("不在采购IBM电脑!");
    }
}
