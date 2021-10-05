package T05_DesignMode.T05_FactoryMethod;

import T05_DesignMode.T05_FactoryMethod.Impl.BlackHuman;
import T05_DesignMode.T05_FactoryMethod.Impl.WhiteHuman;
import T05_DesignMode.T05_FactoryMethod.Impl.YellowHuman;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/10/5 9:41
 * @description
 * @editUser hx
 * @editTime 2021/10/5 9:41
 * @editDescription 首先定义女娲, 把神先定义出来
 */
public class NvWaGod {
    public static void main(String[] args) {
        //    女娲第一次造人, 没啥经验,试验性质, 欠点火候,
        System.out.println("-----------------第一批人类: 白人-----------------");
        Human white = HumanFactory.createHuman(WhiteHuman.class);
        white.cry();
        white.laugh();
        white.talk();

        //     女娲第一次造人, 三昧真火有点旺了, 黑了
        System.out.println("-----------------第一批人类: 黑人-----------------");
        Human black = HumanFactory.createHuman(BlackHuman.class);
        black.cry();
        black.laugh();
        black.talk();

        //     女娲第一次造人, 三昧真火刚刚好
        System.out.println("-----------------第一批人类: 黑人-----------------");
        Human yellow = HumanFactory.createHuman(YellowHuman.class);
        yellow.cry();
        yellow.laugh();
        yellow.talk();


        //    最后,女娲烦躁了，爱是啥人类就是啥人类，烧吧
        for (int i = 0; i < 1000000; i++) {
            System.out.println("-------------女娲开始随机造人啦-----------");
            Human human = HumanFactory.createHuman();
            human.talk();
            human.laugh();
            human.cry();
        }


    }


}
