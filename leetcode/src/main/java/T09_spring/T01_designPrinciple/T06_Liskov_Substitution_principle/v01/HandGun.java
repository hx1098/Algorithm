package T09_spring.T01_designPrinciple.T06_Liskov_Substitution_principle.v01;

/**
 * @author hx1098
 * @version 1.0.0
 * @createTime 2022/10/8 17:41
 * @description 里氏替换原则
 * @editUser hx1098
 * @editTime 2022/10/8 17:41
 * @editDescription  手枪
 *
 *
 */
public class HandGun extends AbstractGun {

    @Override
    public void shot() {
        System.out.println("手枪射击！");
    }
}
