package T05_DesignMode.T07_Facade;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/10/7 13:34
 * @description
 * @editUser hx
 * @editTime 2021/10/7 13:34
 * @editDescription 定义一个写信的过程.
 */
public interface LetterProcess {

    /**定义写信的内容*/
    public void writeContext(String context);

    /**写信封*/
    public void fillEnvelop(String address);

    /**把信放到信封里*/
    public void letterIntoEnvelop();

    /**然后进行邮递*/
    public void sendLetter();


}
