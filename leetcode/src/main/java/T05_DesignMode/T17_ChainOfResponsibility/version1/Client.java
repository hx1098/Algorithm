package T05_DesignMode.T17_ChainOfResponsibility.version1;

import T05_DesignMode.T17_ChainOfResponsibility.version1.impl.Father;
import T05_DesignMode.T17_ChainOfResponsibility.version1.impl.Husband;
import T05_DesignMode.T17_ChainOfResponsibility.version1.impl.Son;
import T05_DesignMode.T17_ChainOfResponsibility.version1.impl.Women;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/10/25 15:26
 * @description
 * @editUser hx
 * @editTime 2021/10/25 15:26
 * @editDescription 不多说了...
 */
public class Client {


    public static void main(String[] args) {
        //    随机生成几个女性朋友,
        Random random = new Random();
        ArrayList<IWomen> iWomen = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            iWomen.add(new Women(random.nextInt(4), "我要出去逛街"));
        }

        //    定义单个请示对象
        IHandler father = new Father();
        IHandler husband = new Husband();
        IHandler son = new Son();

        for (IWomen iWoman : iWomen) {
            //未婚 请示父亲
            if (iWoman.getType() == 1) {
                System.out.println("\n--------女儿向父亲请示-------");
                father.HandleMessage(iWoman);
            } else if (iWoman.getType() == 2) {
                System.out.println("\n--------妻子向丈夫请示-------");
                husband.HandleMessage(iWoman);
            } else if (iWoman.getType() == 3) {
                System.out.println("\n--------母亲向儿子请示-------");
                son.HandleMessage(iWoman);
            } else {
                System.out.println("没有任何指示,暂时什么都不做...");
            }
        }


    }
}
