package T09_spring.T01_designPrinciple.T06_Liskov_Substitution_principle.v01;

/**
 * @author hx1098
 * @version 1.0.0
 * @createTime 2022/10/8 17:03
 * @description
 * @editUser hx1098
 * @editTime 2022/10/8 17:03
 * @editDescription 里氏替换原则
 */
public class main {

    public static void main(String[] args) {
        Soldier soldier = new Soldier();
        soldier.setGun(new HandGun());
        soldier.killEmney();
    }


}
