package T05_DesignMode.T06_AbstractFactory;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/10/6 20:04
 * @description
 * @editUser hx
 * @editTime 2021/10/6 20:04
 * @editDescription 世界上有哪些类型的人, 统统列出来.
 */
public enum  HumanEnum {
    /**男性黄种人*/
    YellowMaleHuman("T05_DesignMode.T06_AbstractFactory.AbstractImpl.YellowMaleHuman"),

    /**女性黄种人*/
    YelloFemaleHuman("T05_DesignMode.T06_AbstractFactory.AbstractImpl.YellowFemaleHuman"),

    /**女性白种人*/
    WhiteFemaleHuman("T05_DesignMode.T06_AbstractFactory.AbstractImpl.WhiteFemaleHuman"),

    /**男性白种人*/
    WhiteMaleHuman("T05_DesignMode.T06_AbstractFactory.AbstractImpl.WhiteMaleHuman"),

    /**女性黑种人*/
    BlackFemaleHuman("T05_DesignMode.T06_AbstractFactory.AbstractImpl.BlackFemaleHuman"),

    /**男性黑种人*/
    BlackMaleHuman("T05_DesignMode.T06_AbstractFactory.AbstractImpl.BlackMaleHuman");

    private String value = "";

    //定义构造函数，目的是Data(value)类型的相匹配
    private HumanEnum(String value){
        this.value = value;
    }

    public String getValue(){
        return this.value;
    }


    /*
     * java enum类型尽量简单使用，尽量不要使用多态、继承等方法
     * 毕竟用Clas完全可以代替enum
     */

}
