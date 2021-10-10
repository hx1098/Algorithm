package T05_DesignMode.T10_Builder.newImpl;

import T05_DesignMode.T10_Builder.CarBuilder;
import T05_DesignMode.T10_Builder.CarModel;
import T05_DesignMode.T10_Builder.impl.BencModel;

import java.util.ArrayList;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/10/10 20:59
 * @description
 * @editUser hx
 * @editTime 2021/10/10 20:59
 * @editDescription 换了新设备造出来的二代奔驰车
 *
 * 各种设施都给了，我们按照一定的顺序制造一个奔驰车
 */
public class BenzBuilder extends CarBuilder {

    private BencModel bencModel = new BencModel();

    /**将传入的造车步骤给设置出来, 造出来车, 等待用户来取*/
    @Override
    public void setSeqence(ArrayList<String> arrayList) {
        this.bencModel.setSequence(arrayList);
    }

    /**将造出的车返回出去给客户*/
    @Override
    public CarModel getCarModel() {
        return this.bencModel;
    }
}
