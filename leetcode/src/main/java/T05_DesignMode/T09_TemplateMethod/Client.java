package T05_DesignMode.T09_TemplateMethod;

import T05_DesignMode.T09_TemplateMethod.extend.HummerH1Model;
import T05_DesignMode.T09_TemplateMethod.extend.HummerH2Model;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/10/9 16:45
 * @description
 * @editUser hx
 * @editTime 2021/10/9 16:45
 * @editDescription 客户开始使用这个模型了.
 */
public class Client {
    public static void main(String[] args) {

        //  客户开着H1出去炸街了
        HummerModel hummerModel = new HummerH1Model();
        hummerModel.run();


        //  客户开着H2出去炸街了
        HummerModel h2 = new HummerH2Model();
        h2.run();

    }
}
