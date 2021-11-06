package T05_DesignMode.T24_Memento.version3;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/11/5 9:21
 * @description
 * @editUser hx
 * @editTime 2021/11/5 9:21
 * @editDescription 备忘录模式
 */
public class Boy {

    /**男孩状态*/
    private String state = "";

    /**认识女孩后状态可能改变，比如心情，手中的花等*/
    public void changeState() {
        this.state = "心情可能不好.";
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    /**创建一个备份*/
    public Memento createMemento() {
        return new Memento(this.state);
    }

    /**恢复一个备份*/
    public void restoreMemento(Memento memento) {
        this.setState(memento.getState());
    }
}
