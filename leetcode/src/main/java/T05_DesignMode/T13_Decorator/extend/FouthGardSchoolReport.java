package T05_DesignMode.T13_Decorator.extend;

import T05_DesignMode.T13_Decorator.SchoolReport;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/10/16 16:06
 * @description
 * @editUser hx
 * @editTime 2021/10/16 16:06
 * @editDescription 四年级的成绩单, 这也是我们学校第一次实施, 以前没干过这末缺德的事儿
 */
public class FouthGardSchoolReport extends SchoolReport {


    /**我的成绩单*/
    @Override
    public void report() {
        System.out.println("尊敬的小明家长: ");
        System.out.println("巴拉巴拉巴拉...");
        System.out.println( "语文: 58   数学: 58  体育: 60  自然: 68");
        System.out.println("巴拉巴拉巴拉");
        System.out.println("   家长签名:    ");
    }

    /**家长签名*/
    @Override
    public void sign(String name) {
        System.out.println("家长签名为: " + name);
    }
}
