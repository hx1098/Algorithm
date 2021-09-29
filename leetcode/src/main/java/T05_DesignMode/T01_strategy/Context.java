package T05_DesignMode.T01_strategy;

import T05_DesignMode.T01_strategy.impl.IStrategy;

/**
 * @author hx
 * @createTime 2021/9/29 15:32
 * @version 1.0.0
 * @description
 * @editUser hx
 * @editTime 2021/9/29 15:32
 * @editDescription 计谋有了,那还需要有锦囊来存储计谋
 */
public class Context {

    /**构造函数, 你要使用的那个妙计*/
    private IStrategy iStrategy;

    /**构造方法*/
    public Context(IStrategy iStrategy) {
        this.iStrategy = iStrategy;
    }

    /**使用计谋了, 你要看我出招了, 我到底值杀, 还是去, 还是留...*/
    public void operate() {
        this.iStrategy.operate();
    }
}
