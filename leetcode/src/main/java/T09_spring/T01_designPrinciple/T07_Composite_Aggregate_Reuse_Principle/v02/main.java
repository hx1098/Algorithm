package T09_spring.T01_designPrinciple.T07_Composite_Aggregate_Reuse_Principle.v02;

/**
 * @author hx1098
 * @version 1.0.0
 * @createTime 2022/10/18 14:33
 * @description
 * @editUser hx1098
 * @editTime 2022/10/18 14:33
 * @editDescription 合成复用原则 尽量使用对象组合 而不是继承关系达到软件复用的目的
 */
public class main {

    public static void main(String[] args) {
        ProductionDao dao = new ProductionDao();
        dao.setConnection(new MysqlDBConnection());
        dao.addProduct();

    }

}
