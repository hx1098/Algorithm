package T05_DesignMode.T24_Memento.version3;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/11/5 10:13
 * @description
 * @editUser hx
 * @editTime 2021/11/5 10:13
 * @editDescription 创建一个备忘录管理者
 */
public class CareTaker {

    /**备忘录对象*/
    private Memento memento;

    public Memento getMemento() {
        return memento;
    }

    public void setMemento(Memento memento) {
        this.memento = memento;
    }
}
