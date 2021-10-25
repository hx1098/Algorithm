package T05_DesignMode.T17_ChainOfResponsibility.version1;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/10/24 13:29
 * @description
 * @editUser hx
 * @editTime 2021/10/24 13:29
 * @editDescription 古代悲哀女性的总称
 */
public interface IWomen {

    /**活的个人状况*/
    public int getType();

    /**活的个人请示,你要干什么, 逛街, 约会,还是看电影*/
    public String getRequest();


}
