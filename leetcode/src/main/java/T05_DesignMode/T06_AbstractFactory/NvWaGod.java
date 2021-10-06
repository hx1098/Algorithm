package T05_DesignMode.T06_AbstractFactory;

import T05_DesignMode.T06_AbstractFactory.factoryImpl.FemaleHumanFactory;
import T05_DesignMode.T06_AbstractFactory.factoryImpl.MaleHumanFactory;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/10/5 9:41
 * @description
 * @editUser hx
 * @editTime 2021/10/5 9:41
 * @editDescription 女娲要建立两条生茶线,
 * 男性生产线,
 * 女性生产线
 */
public class NvWaGod {
    public static void main(String[] args) {

       /* Class<BlackFemaleHuman> blackFemaleHumanClass = BlackFemaleHuman.class;
        System.out.println(blackFemaleHumanClass.getPackage());
        System.out.println(blackFemaleHumanClass.getModifiers());*/
        //    男性生产线
        HumanFactory maleHumanFactory = new MaleHumanFactory();
        //    女性生产线
        HumanFactory femaleHumanFactory = new FemaleHumanFactory();
        //    生产线建立完毕,开始生产人了.
        Human yellowMaleHuman = maleHumanFactory.createYellowHuman();
        Human femaleHumanYellowaaHuman = femaleHumanFactory.createYellowHuman();

        yellowMaleHuman.cry();
        yellowMaleHuman.sex();
        yellowMaleHuman.laugh();
        yellowMaleHuman.talk();
        System.out.println("==================");
        femaleHumanYellowaaHuman.cry();
        femaleHumanYellowaaHuman.sex();
        femaleHumanYellowaaHuman.laugh();
        femaleHumanYellowaaHuman.talk();

    }


}
