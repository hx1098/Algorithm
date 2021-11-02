package T05_DesignMode.T21_Mediator.version2;

import java.util.Random;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/11/1 16:05
 * @description
 * @editUser hx
 * @editTime 2021/11/1 16:05
 * @editDescription
 */
public class Sale extends AbstractColleague{

    public Sale(AbstractMediator mediator) {
        super(mediator);
    }

    /**
     * 销售IMB型号电脑
     */
    public void sellIBMComputer(int number) {
       super.mediator.execute("sale.sell",number);
        System.out.println("销售IBM电脑" + number + "台");
    }

    /**
     * 反馈销售情况， 0~100之间变化， 0代表根本没人买, 100代表非常畅销,出一个卖一个
     */
    public int getSaleStatus() {
        Random random = new Random(System.currentTimeMillis());
        int saleStatus = random.nextInt(100);
        System.out.println("IBM的销售情况是:" + saleStatus);
        return saleStatus;
    }

    /**
     * 折价进行销售
     */
    public void offSale() {
        //库房有多少卖多少.
       super.mediator.execute("sale.offsell");
    }
}
