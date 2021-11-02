package T05_DesignMode.T21_Mediator.version2;

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
public class Purchase extends AbstractColleague{


    public Purchase(AbstractMediator mediator) {
        super(mediator);
    }

    /**
     * 采购IBM型号的电脑
     */
    public void bugIbmComputer(int  number) {
        super.mediator.execute("purchase.buy",number);
    }


    /**不在采购IMB电脑*/
    public void refuseBuyIBM() {
        System.out.println("不在采购IBM电脑!");
    }
}
