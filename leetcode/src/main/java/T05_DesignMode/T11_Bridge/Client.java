package T05_DesignMode.T11_Bridge;

import T05_DesignMode.T11_Bridge.impl.ClothesCorp;
import T05_DesignMode.T11_Bridge.impl.HouseCorp;
import T05_DesignMode.T11_Bridge.impl.IPadCorp;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/10/11 21:51
 * @description
 * @editUser hx
 * @editTime 2021/10/11 21:51
 * @editDescription 作为老板的我, 必须要开始关系我自己的公司了. 看看公司的运营情况是神魔样子的.
 *
 *  这种类型是比较简单的.
 */
public class Client {

    public static void main(String[] args) {
        System.out.println("-----------------房地产公司是这样的赚钱的.-----------------");
        //  先找到我的公司
        HouseCorp houseCorp = new HouseCorp();
        //  看我如何赚钱的
        houseCorp.makeMoney();
        System.out.println("\n");


        System.out.println("-----------------服饰公司是这样赚钱的-------------------");
        //  先找到我的公司
        ClothesCorp clothesCorp = new ClothesCorp();
        //  看我是如何赚钱的
        clothesCorp.makeMoney();


        System.out.println("\n");
        System.out.println("-----------------ipad公司是这样赚钱的-------------------");
        //  先找到我的公司
        IPadCorp iPadCorp = new IPadCorp();
        //  看我是如何赚钱的
        iPadCorp.makeMoney();




    }

}
