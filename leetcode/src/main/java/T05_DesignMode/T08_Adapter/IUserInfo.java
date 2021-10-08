package T05_DesignMode.T08_Adapter;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/10/8 9:14
 * @description
 * @editUser hx
 * @editTime 2021/10/8 9:14
 * @editDescription  用户信息对象
 */
public interface IUserInfo  {
    /**获取用户姓名*/
    public String getUserName();

    /**获取家庭地址*/
    public String getHomeAddress();

    /**获取电话号码*/
    public String getMoboileNumber();

    /**办公电话*/
    public String getOfficeTelNumber();

    /**获取职位*/
    public String getJobPostion();

    /**获取家庭电话*/
    public String getHomeTelNumber();
}
