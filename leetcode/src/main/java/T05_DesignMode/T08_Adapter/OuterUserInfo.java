package T05_DesignMode.T08_Adapter;

import T05_DesignMode.T08_Adapter.Impl.OuterUser;

import javax.annotation.processing.SupportedSourceVersion;
import java.util.Map;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/10/8 20:46
 * @description
 * @editUser hx
 * @editTime 2021/10/8 20:46
 * @editDescription 这个是适配器, 将外部用户的信息包装成 内部系统可以识别的用户信息
 */
public class OuterUserInfo extends OuterUser implements IUserInfo {

    /**员工信息*/
    private Map baseInfo = super.getUserBaseInfo();
    /**员工家庭信息*/
    private Map homeInfo = super.getUserHomeInfo();
    /**员工的工作信息*/
    private Map officeInfo = super.getUserOfficeInfo();


    @Override
    public String getUserName() {
        String userName = (String)baseInfo.get("userName");
        System.out.println(userName);
        return userName;
    }

    @Override
    public String getHomeAddress() {
        String homeAddress = (String)this.homeInfo.get("homeAddress");
        System.out.println(homeAddress);
        return homeAddress;
    }

    @Override
    public String getMoboileNumber() {
        String mobileNumber = (String)baseInfo.get("mobileNumber");
        System.out.println(mobileNumber);
        return mobileNumber;
    }

    @Override
    public String getOfficeTelNumber() {
        String officeTelNumber = (String)officeInfo.get("officeTelNumber");
        System.out.println(officeTelNumber);
        return officeTelNumber;
    }

    @Override
    public String getJobPostion() {
        String jobPosition = (String)officeInfo.get("jobPosition");
        System.out.println(jobPosition);
        return jobPosition;
    }

    @Override
    public String getHomeTelNumber() {
        String homeTelNumber = (String)homeInfo.get("homeTelNumber");
        System.out.println(homeTelNumber);
        return homeTelNumber;
    }
}
