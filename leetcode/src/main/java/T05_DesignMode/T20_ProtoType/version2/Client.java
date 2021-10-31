package T05_DesignMode.T20_ProtoType.version2;

import lombok.SneakyThrows;

import java.util.Random;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/10/30 8:32
 * @description
 * @editUser hx
 * @editTime 2021/10/30 8:32
 * @editDescription 又到了如何使用的阶段了, 哈哈哈, 来看看这个是如何调用的
 */
public class Client {

    /**
     * 发送账单的数量, 这儿值是从数据库中获取的
     */
    private static int MAX_COUNT = 6;


    @SneakyThrows
    public static void main(String[] args) {
        //模拟发送邮件
        int i = 0;
        //    把模版定义出来, 这个是从数据库中获取
        Mail mail = new Mail(new AdvTemplate());
        mail.setTail("xx银行版权所有");
        while (i < MAX_COUNT) {
            //    一下是每封邮件不同的地方
            Mail clone = (Mail) mail.clone();
            clone.setAppellation(getRandString(5)+"先生(女士)");
            clone.setReceiver(getRandString(5) + "@" + getRandString(8)+".com");
            sendMail(clone);
            i++;
        }


    }

    public static void sendMail(Mail mail) {
        System.out.println("标题:" + mail.getSubject() +"\t收件人:" + mail.getReceiver()+"\t...发送成功!" );
    }

    //获得指定长度的随机字符串
    public static String getRandString(int maxLength) {
        String source = "abcdefghijklmnopqrskuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuffer sb = new StringBuffer();
        Random rand = new Random();
        for (int i = 0; i < maxLength; i++) {
            sb.append(source.charAt(rand.nextInt(source.length())));
        }
        return sb.toString();

    }


}
