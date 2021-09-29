package T05_DesignMode.T01_strategy.impl;

/**
 * @author hx
 * @createTime 2021/9/29 15:20
 * @option
 * @description 首先定一个策略接口，这是诸葛亮老人家给赵云的三个锦囊妙计的接口
 */
public interface IStrategy {

    /**每一个锦囊妙计都是一个可执行的算法, 这里要搞是*/
    public void operate();

}
