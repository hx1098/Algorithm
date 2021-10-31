package T05_DesignMode.T20_ProtoType.version2;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/10/30 8:28
 * @description
 * @editUser hx
 * @editTime 2021/10/30 8:28
 * @editDescription  邮件类
 */
public class Mail implements Cloneable{

    /**收件人*/
    private String receiver;

    /**邮件名称*/
    private String subject;

    /**称谓*/
    private String appellation;

    /**邮件内容*/
    private String context;

    /**邮件的尾部,一般都是加上xx版权等信息*/
    private String tail;

    public Mail( ) {
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Mail mail = null;
        mail = (Mail) super.clone();
        return mail;
    }

    /**构造函数, 只做了邮件名称和邮件内容*/
    public Mail(AdvTemplate advTemplate) {
        this.subject = advTemplate.getAdvSubject();
        this.context = advTemplate.getAdvContext();
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getAppellation() {
        return appellation;
    }

    public void setAppellation(String appellation) {
        this.appellation = appellation;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getTail() {
        return tail;
    }

    public void setTail(String tail) {
        this.tail = tail;
    }
}
