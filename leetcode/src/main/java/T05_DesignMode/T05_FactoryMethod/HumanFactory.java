package T05_DesignMode.T05_FactoryMethod;


import java.util.List;
import java.util.Random;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/10/5 9:32
 * @description
 * @editUser hx
 * @editTime 2021/10/5 9:32
 * @editDescription 相当于八卦炉
 * 今天讲女娲造人的故事，这个故事梗概是这样的：
 * * 很久很久以前，盘古开辟了天地，用身躯造出日月星辰、山川草木，天地一片繁华
 * * One day，女娲下界走了一遭，哎！太寂寞，太孤独了，没个会笑的、会哭的、会说话的东东
 * * 那怎么办呢？不用愁，女娲，神仙呀，造出来呀，然后捏泥巴，放八卦炉（后来这个成了太白金星的宝
 * 贝）中烤，于是就有了人：
 * * 我们把这个生产人的过程用Java程序表现出来
 */
public class HumanFactory {
    /**
     * 定义一个烤箱,你把塞进去,人就出来了,这个很先进
     */
    public static Human createHuman(Class c) {
        Human human = null;
        //产生一个人类
        try {
            human = (Human) Class.forName(c.getName()).newInstance();
        } catch (InstantiationException e) {
            //    你说个人类的颜色, 要白的要黑的你说了算
            System.out.println("必须制定人类颜色....");
        } catch (IllegalAccessException e) {
            //    定义的人类的颜色有问题, 那就考不出来了,
            System.out.println("人类定义有误....");
        } catch (ClassNotFoundException e) {
            //     你随便说个人类, 我到哪给你制造去
            System.out.println("滚, 你制定的人类找不到...");
        }
        return human;
    }

    /**
     * 制定一个人类制造太麻烦了, 我不指定了, 丢进去一团看你自己的造化吧
     */
    public static Human createHuman() {
        Human human = null;
        //获取有多少个实现类,多少个人类
        List<Class> allClassByInterface = ClassUtils.getAllClassByInterface(Human.class);
        //    八卦炉自己想烧神魔杨的人就烧什么人
        Random random = new Random();
        int rand = random.nextInt(allClassByInterface.size());

        human = createHuman(allClassByInterface.get(rand));
        return human;
    }

}
