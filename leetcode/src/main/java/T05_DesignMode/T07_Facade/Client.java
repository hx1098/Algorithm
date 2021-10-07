package T05_DesignMode.T07_Facade;

import T05_DesignMode.T07_Facade.Impl.LetterProcessImpl;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/10/7 13:44
 * @description
 * @editUser hx
 * @editTime 2021/10/7 13:44
 * @editDescription 我开始给朋友写信了.  这个属于普通的写信.
 */
public class Client {

    public static void main(String[] args) {
        //      创建一个处理信件的过程
        LetterProcess letterProcess = new LetterProcessImpl();
        //      开始写信
        letterProcess.writeContext("hello, my name is LIMing, xxxxxxxxxxxxxxxxxxxxxxxxxxx");
        //      写地址
        letterProcess.fillEnvelop("shanghai,nanjing east Road sb110 No.");
        //      放入信封
        letterProcess.letterIntoEnvelop();
        //      进行邮寄
        letterProcess.sendLetter();


    }

}
