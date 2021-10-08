package T05_DesignMode.T08_Adapter;

import java.util.Map;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/10/8 20:33
 * @description
 * @editUser hx
 * @editTime 2021/10/8 20:33
 * @editDescription 外系统人员的处理
 */
@SuppressWarnings("all")
public interface IOuterUser {

    /**基本信息,比如名称,行呗,手机号码*/
    public Map getUserBaseInfo();

    /**工作区域信息*/
    public Map getUserOfficeInfo();

    /**用户的家庭信息*/
    public Map getUserHomeInfo();


}
