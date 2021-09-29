package T05_DesignMode.T01_strategy;

import T05_DesignMode.T01_strategy.impl.BackDoor;
import T05_DesignMode.T01_strategy.impl.BlockEnemy;
import T05_DesignMode.T01_strategy.impl.GivenGreenLight;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/9/29 15:45
 * @description
 * @editUser hx
 * @editTime 2021/9/29 15:45
 * @editDescription 赵云他来了, 她来了, 他根据诸葛亮的交代,依次拆开妙计..
 * 赵云并不知每次拆开的锦囊使用的到底是哪个策略哇, 这
 * 里其实已经将锦囊的计谋名称写出来了,只要拆出来就可以了,
 * 另外加策略的话就直接在Context中加就可以了.
 *
 * 优点: 高内聚低耦合
 *
 * 例子: java 中的 Comparator
 *
 */

public class ZhaoYun {

    public static void main(String[] args) {
        Context context;

        //刚刚到吴国的时候拆开了一个
        System.out.println("===============刚刚到吴国的时候拆开了一个..================");
        context = new Context(new BackDoor());
        //拆开执行
        context.operate();
        System.out.println("\n\n\n");


        //刘备(打了一辈子仗了, 就不能好好享受一下吗? 接着奏乐, 接着舞)乐不思蜀了, 赵云很是气愤,
        System.out.println("===============刘备乐不思蜀了, 拆开第二个..================");
        context = new Context(new GivenGreenLight());
        //拆开执行
        context.operate();
        System.out.println("\n\n\n");


        //刘备携夫人被孙权追到了, 咋办, 拆开第三个锦囊, 没办法主角光环.
        System.out.println("===============刘备乐不思蜀了, 拆开第三个..================");
        context = new Context(new BlockEnemy());
        //拆开执行 孙权退兵
        context.operate();
        System.out.println("\n\n\n");



    }

}
