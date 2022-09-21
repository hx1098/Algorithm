package T09_spring.T01_designPrinciple.T01_open_closed_principle;

/**
 * @author hx1098
 * @createTime 2022/9/22 06:19
 * @option
 * @description 开闭原则，对拓展开放，对修改关闭，提高软件对复用性和可维护性
 */
public interface ICourse {

    Integer getId();

    String getName();

    Double getPrice();
}
