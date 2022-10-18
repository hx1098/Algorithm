package T09_spring.T01_designPrinciple.T07_Composite_Aggregate_Reuse_Principle.v02;

/**
 * @author hx1098
 * @version 1.0.0
 * @createTime 2022/10/18 14:35
 * @description
 * @editUser hx1098
 * @editTime 2022/10/18 14:35
 * @editDescription 合成复用原则
 */
public class OracleDBConnection extends DBConnection {

    @Override
    public String getConnection() {
        return "oracle数据库连接";
    }
}
