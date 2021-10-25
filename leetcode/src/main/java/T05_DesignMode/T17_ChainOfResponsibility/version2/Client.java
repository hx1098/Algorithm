package T05_DesignMode.T17_ChainOfResponsibility.version2;

import T05_DesignMode.T17_ChainOfResponsibility.version2.impl.Father;
import T05_DesignMode.T17_ChainOfResponsibility.version2.impl.Husband;
import T05_DesignMode.T17_ChainOfResponsibility.version2.impl.Son;
import T05_DesignMode.T17_ChainOfResponsibility.version2.impl.Women;

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
        Handler father = new Father();
        Handler husband = new Husband();
        Handler son = new Son();

        //    设置请示顺序
        father.setNextHandler(husband);
        husband.setNextHandler(son);

        for (IWomen iWoman : iWomen) {
            father.HandleMessage(iWoman);
        }

    }
}
