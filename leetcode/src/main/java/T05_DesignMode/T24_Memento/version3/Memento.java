package T05_DesignMode.T24_Memento.version3;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/11/5 9:43
 * @description
 * @editUser hx
 * @editTime 2021/11/5 9:43
 * @editDescription 创建一个备忘录
 */
public class Memento {

    /**男孩的状态*/
    private String state = "";

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
