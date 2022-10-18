package T09_spring.T01_designPrinciple.T06_Liskov_Substitution_principle.v01;

/**
 * @author hx1098
 * @version 1.0.0
 * @createTime 2022/10/18 13:53
 * @description
 * @editUser hx1098
 * @editTime 2022/10/18 13:53
 * @editDescription 士兵实现类
 */
public class Soldier {

    private AbstractGun gun;

    public void setGun(AbstractGun gun) {
        this.gun = gun;
    }

    public void killEmney() {
        System.out.println("士兵杀敌人！ ");
        gun.shot();
    }


    


}
