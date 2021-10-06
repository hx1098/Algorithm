package T05_DesignMode.T06_AbstractFactory;

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
 * * 我们把这个生产人的过程用Java程序表现出来
 */
public interface HumanFactory {

    //制造一个黄种人
    public Human createYellowHuman();

    //制造一个白种人
    public Human createWhiteHuman();

    //制造一个黑种人
    public Human createBlackHuman();

}
