package T05_DesignMode.T24_Memento.version1;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/11/5 9:25
 * @description
 * @editUser hx
 * @editTime 2021/11/5 9:25
 * @editDescription 看看状态是如何改变的。
 */
public class Client {

    public static void main(String[] args) {

        //  声明出猪脚(主角)
        Boy boy = new Boy();
        //    初始化当前心态,
        boy.setState("心情很棒!");
        System.out.println("---------男孩现在的心态-----------");
        System.out.println(boy.getState());

        //    需要记录下当前的心态
        Boy boyBackUp = new Boy();
        boyBackUp.setState(boy.getState());

        //    男孩去追女孩, 心态改变
        boy.changeState();
        System.out.println("\n----------男孩追女孩后的心态---------");
        System.out.println(boy.getState());

        //    追失败后恢复心态
        boy.setState(boyBackUp.getState());
        System.out.println("---------男孩恢复后的心态,--------");
        System.out.println(boy.getState());

    }

}
