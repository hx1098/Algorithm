package T05_DesignMode.T10_Builder;

import T05_DesignMode.T10_Builder.impl.BencModel;

import java.util.ArrayList;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/10/10 20:46
 * @description
 * @editUser hx
 * @editTime 2021/10/10 20:46
 * @editDescription  传统的客户提车是这样的.
 *
 * 客户1过啦提车了:
 * 要求:  我要这样的顺序来开车, 那好, 我来造车
 */
public class Client1 {
    public static void main(String[] args) {

        BencModel bencModel = new BencModel();
        ArrayList<String> seq = new ArrayList<>();

        //  客户要求, 启动之前先发动引擎
        seq.add("engine boom");
        //  客户要求, 启动起来
        seq.add("start");
        //  客户要求, 停止汽车
        seq.add("stop");

        //    然后我们把这个汽车交付个车主
        bencModel.setSequence(seq);
        bencModel.run();

    }

}
