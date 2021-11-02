package T05_DesignMode.T21_Mediator.version2;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/11/2 14:01
 * @description
 * @editUser hx
 * @editTime 2021/11/2 14:01
 * @editDescription
 */
public abstract class AbstractColleague {

    protected AbstractMediator mediator;

    public AbstractColleague(AbstractMediator mediator) {
        this.mediator = mediator;
    }
}
