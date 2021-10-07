package T05_DesignMode.T07_Facade.Impl;

import T05_DesignMode.T07_Facade.LetterProcess;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/10/7 13:38
 * @description
 * @editUser hx
 * @editTime 2021/10/7 13:38
 * @editDescription 写信的具体实现
 */
public class LetterProcessImpl implements LetterProcess {

    /**写信*/
    @Override
    public void writeContext(String context) {
        System.out.println("填写信的内容..." + context);
    }

    /**信封上填写必要的内容*/
    @Override
    public void fillEnvelop(String address) {
        System.out.println("填写信封的必要的内容..." + address);
    }

    /**把信放入信封中, 并封好*/
    @Override
    public void letterIntoEnvelop() {
        System.out.println("把信放入信封中...");
    }

    /**塞入邮箱, 邮寄*/
    @Override
    public void sendLetter() {
        System.out.println("邮递信件...");
    }
}
