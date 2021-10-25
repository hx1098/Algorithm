package T05_DesignMode.T17_ChainOfResponsibility.version1;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/10/25 15:16
 * @description
 * @editUser hx
 * @editTime 2021/10/25 15:16
 * @editDescription 有处理权利的人员接口
 */
public interface IHandler {

    /**
     * 一个女性要逛街, 你要处理这个请求,
     * @param women
     */
    public void HandleMessage(IWomen women);

}
