package T05_DesignMode.T20_ProtoType.version2;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/10/30 8:24
 * @description
 * @editUser hx
 * @editTime 2021/10/30 8:24
 * @editDescription  广告模版接口
 */
public class AdvTemplate {

    /**广告信名称*/
    private String advSubject = "xx银行国庆信用卡抽奖活动";

    /**广告信内容*/
    private String advContext = "国庆抽奖活动通知: 只要刷卡就送你一百万!";

    /**获取广告信的名称*/
    public String getAdvSubject() {
        return advSubject;
    }

    /**获取广告信的内容*/
    public String getAdvContext() {
        return advContext;
    }
}
