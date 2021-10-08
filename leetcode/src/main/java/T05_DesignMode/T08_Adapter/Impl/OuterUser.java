package T05_DesignMode.T08_Adapter.Impl;

import T05_DesignMode.T08_Adapter.IOuterUser;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/10/8 20:37
 * @description
 * @editUser hx
 * @editTime 2021/10/8 20:37
 * @editDescription 外系统人员用户信息的实现类 (思考: 如何将外系统用户信息包装成我们的公司员工信息.)
 */
public class OuterUser implements IOuterUser {

    /**用户的基本信息*/
    @Override
    public Map getUserBaseInfo() {
        HashMap baseMap = new HashMap();
        baseMap.put("userName", "这个员工的名称叫做混世魔王");
        baseMap.put("mobileNumber", "这个员工的电话是...");
        return baseMap;
    }

    /**员工的工作信息*/
    @Override
    public Map getUserOfficeInfo() {
        HashMap map = new HashMap();
        map.put("jobPosition", "这个人的职位是boss");
        map.put("officeTelNumber", "员工的办公室电话是...");
        return map;
    }

    @Override
    public Map getUserHomeInfo() {
        HashMap map = new HashMap();
        map.put("homeTelNumber", "员工的家庭电话是。。。");
        map.put("homeAddress", "员工的家庭地址是。。。");
        return map;
    }
}
