package T05_DesignMode.T07_Facade;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/10/7 13:44
 * @description
 * @editUser hx
 * @editTime 2021/10/7 13:44
 * @editDescription 我开始给朋友写信了.  这个属于普通的写信.
 */
public class Client2 {

    public static void main(String[] args) {
        //      创建一个处理信件的过程
        ModenPostOffice letterProcess = new ModenPostOffice();
        //      开始写信
        String context = "hello, I am jack, fuck your xxxxx!";
        String address = "dongjing 234 No.";
        letterProcess.sendLetter(context,address);


    }

}
