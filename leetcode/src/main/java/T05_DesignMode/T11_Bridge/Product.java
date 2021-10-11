package T05_DesignMode.T11_Bridge;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/10/11 22:05
 * @description
 * @editUser hx
 * @editTime 2021/10/11 22:05
 * @editDescription 公司多了, 我就成立一个集团公司, 汇总了我下属所有公司的产品线类
 */
public abstract class Product {

    /**集团公司比较强大,我接活就行了,啥产品都能给你造出来*/
    public abstract void beProducted();

    /**集团公司人脉比较广, 你生产出来啥都能给你卖出去*/
    public abstract void  beSelled();


}
