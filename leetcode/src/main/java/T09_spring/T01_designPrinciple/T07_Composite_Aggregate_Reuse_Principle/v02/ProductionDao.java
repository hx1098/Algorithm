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
public class ProductionDao {

    private DBConnection connection;

    public void setConnection(DBConnection connection) {
        this.connection = connection;
    }

    public void addProduct() {
        String conn = connection.getConnection();
        System.out.println("使用connection添加产品" + conn);
    }
}
