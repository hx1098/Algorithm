package T05_DesignMode.T02_Proxy;

import T05_DesignMode.T02_Proxy.Impl.WangPo;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/9/29 16:51
 * @description
 * @editUser hx
 * @editTime 2021/9/29 16:51
 * @editDescription 定义一个西门庆老色P, 这个人不用过多介绍了, 不知道祸害多少人了
 */
public class XiMenQing {
    /**
     * 剧情大概是这样的: 武大上街卖烧饼去了, 潘金莲在连衣服, 刚好西门庆走过来,然后就有了一系列的 孽缘,
     * 刚好被王婆看到, 就被牵了线搭了桥,还收了不少好处
     **/
    public static void main(String[] args) {

        //大喊一声, 叫王婆出来
        WangPo wangPo = new WangPo();
        //然后西门庆就说，我要和潘金莲happy，然后王婆就安排了西门庆丢筷子的那出戏

        //虽然表面上是和王婆在做, 实际上是爽的是潘金莲.
        wangPo.makeEyesWithMan();
        wangPo.happyWithMan();

    }

}
