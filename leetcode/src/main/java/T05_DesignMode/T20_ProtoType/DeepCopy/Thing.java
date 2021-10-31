package T05_DesignMode.T20_ProtoType.DeepCopy;

import java.util.ArrayList;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/10/30 9:25
 * @description
 * @editUser hx
 * @editTime 2021/10/30 9:25
 * @editDescription
 */
public class Thing implements Cloneable {

    /**定义一个私有变量*/
    private ArrayList<String> arrayList = new ArrayList<>();

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Thing thing = null;
        thing =  (Thing)super.clone();
        return thing;
    }

    public ArrayList<String> getValue() {
        return this.arrayList;
    }

    public void setValue(String value) {
        this.arrayList.add(value);
    }
}
