package T05_DesignMode.T08_Adapter;

import T05_DesignMode.T08_Adapter.Impl.UserInfo;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/10/8 20:31
 * @description
 * @editUser hx
 * @editTime 2021/10/8 20:31
 * @editDescription 这是我们的具体应用, 比如老板要查20~30岁女性的所有信息
 */
public class App {

    public static void main(String[] args) {
        ////    么有外联系统是后是这样写的...
        //IUserInfo yongGirl = new UserInfo();
        //
        ////    从数据库库中查到100个
        //for (int i = 0; i < 100; i++) {
        //    yongGirl.getMoboileNumber();
        //}

        //老板一想不对呀, 兔子不吃窝边草, 我去找附近的分公司的人力资源去....嘿嘿
        IUserInfo userInfo = new OuterUserInfo();

        for (int i = 0; i < 101; i++) {
            userInfo.getMoboileNumber();
        }

    }

}
