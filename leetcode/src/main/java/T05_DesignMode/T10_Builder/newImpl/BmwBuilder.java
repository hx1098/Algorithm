package T05_DesignMode.T10_Builder.newImpl;

import T05_DesignMode.T10_Builder.CarBuilder;
import T05_DesignMode.T10_Builder.CarModel;
import T05_DesignMode.T10_Builder.impl.BmwModel;

import java.util.ArrayList;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/10/10 20:40
 * @description
 * @editUser hx
 * @editTime 2021/10/10 20:40
 * @editDescription 换了新设备造出来的二代宝马车
 */
public class BmwBuilder extends CarBuilder {

    /**车辆模型类*/
    private BmwModel bmwModel = new BmwModel();

    /**将传入的造车步骤给设置出来, 造出来车, 等待用户来取*/
    @Override
    public void setSeqence(ArrayList<String> arrayList) {
        this.bmwModel.setSequence(arrayList);
    }

    /**将造出的车返回出去给客户*/
    @Override
    public CarModel getCarModel() {
        return bmwModel;
    }
}
