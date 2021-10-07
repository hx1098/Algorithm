package T05_DesignMode.T07_Facade;

import T05_DesignMode.T07_Facade.Impl.LetterProcessImpl;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/10/7 13:56
 * @description
 * @editUser hx
 * @editTime 2021/10/7 13:56
 * @editDescription 门面模式的投递
 */
public class ModenPostOffice {


    private LetterProcess letterProcess = new LetterProcessImpl();
    private Police police = new Police();

    public void sendLetter(String context, String address) {
        /**帮你写信*/
        letterProcess.writeContext(context);
        /**写好信封*/
        letterProcess.fillEnvelop(address);

        /**警察要检查信件了*/
        police.checkLetter(letterProcess);

        /**放入信封*/
        letterProcess.letterIntoEnvelop();
        /**投递进行邮寄*/
        letterProcess.sendLetter();
    }
}
