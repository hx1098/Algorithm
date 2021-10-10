package T05_DesignMode.T10_Builder;

import java.util.ArrayList;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/10/10 20:54
 * @description
 * @editUser hx
 * @editTime 2021/10/10 20:54
 * @editDescription  现在我要个客户使用新型的机器来造车了.你需要什么样的需求,给我们直接说出来,
 */
public abstract class CarBuilder {

    /**建造一个模型,你要给我一个顺序,就是组装顺序,*/
    public abstract void setSeqence(ArrayList<String> arrayList);

    /**设置完毕顺序会之后, 会直接拿到这个车辆模型.*/
    public abstract CarModel getCarModel();


}
