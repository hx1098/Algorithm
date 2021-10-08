package T05_DesignMode.T08_Adapter.Impl;

import T05_DesignMode.T08_Adapter.IUserInfo;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/10/8 20:25
 * @description
 * @editUser hx
 * @editTime 2021/10/8 20:25
 * @editDescription
 */
public class UserInfo implements IUserInfo {

    @Override
    public String getUserName() {
        System.out.println("姓名是....");
        return null;
    }

    /**获取员工家庭地址,下属送礼也比较方便了.*/
    @Override
    public String getHomeAddress() {
        System.out.println("这里是员工的家庭地址....");
        return null;
    }

    /**移动手机电话*/
    @Override
    public String getMoboileNumber() {
        System.out.println("这个人的手机号码是.10086...");
        return null;
    }

    /**办公室电话, 烦躁的时候最好吧电话踢掉*/
    @Override
    public String getOfficeTelNumber() {
        System.out.println("办公室电话是...");
        return null;
    }

    /**职位*/
    @Override
    public String getJobPostion() {
        System.out.println("这个人的职位是经理还是小兵....");
        return null;
    }

    /**家庭电话号码*/
    @Override
    public String getHomeTelNumber() {
        System.out.println("员工的家庭电话号码是...");
        return null;
    }
}
