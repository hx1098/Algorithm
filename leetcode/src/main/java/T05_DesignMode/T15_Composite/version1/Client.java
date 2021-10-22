package T05_DesignMode.T15_Composite.version1;

import T05_DesignMode.T15_Composite.version1.impl.Branch;
import T05_DesignMode.T15_Composite.version1.impl.Leaf;
import T05_DesignMode.T15_Composite.version1.impl.Root;

import java.util.ArrayList;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/10/21 17:47
 * @description
 * @editUser hx
 * @editTime 2021/10/21 17:47
 * @editDescription Client的作用是组装这棵树，并遍历一遍
 */
public class Client {

    public static void main(String[] args) {

        /**产生一个跟节点*/
        IRoot ceo = new Root("王经理", "总经理", 100000);

        /**产生单个部门经理*/
        IBranch dev = new Branch("刘经理", "研发经理", 10000);
        IBranch sale = new Branch("张经理", "销售经理", 20000);
        IBranch finance = new Branch("张经理", "财务经理", 30000);

        //    再把三个小组长生产出来
        IBranch firstDevGroup = new Branch("村上春树", "开发一组长", 8000);
        IBranch secondDevGroup = new Branch("山本一郎", "开发二组长", 9000);

        ILeaf zhengLaoLiu = new Leaf("郑老六","研发部副总",20000);

        /*剩下的就交给小兵了*/
        ILeaf a = new Leaf("a", "开发人员",5000);
        ILeaf B = new Leaf("B", "开发人员",5000);
        ILeaf h = new Leaf("H", "开发人员",2000);
        ILeaf u = new Leaf("U", "开发人员",5000);
        ILeaf j = new Leaf("J", "开发人员",5000);
        ILeaf k = new Leaf("K", "销售",8000);
        ILeaf l = new Leaf("L", "财务",5000);
        ILeaf d = new Leaf("D", "秘书",5000);

        ceo.add(dev);
        ceo.add(sale);
        ceo.add(finance);
        ceo.add(d);


        dev.add(firstDevGroup);
        dev.add(secondDevGroup);
        dev.add(zhengLaoLiu);

        firstDevGroup.add(a);
        firstDevGroup.add(B);

        secondDevGroup.add(h);
        secondDevGroup.add(u);
        secondDevGroup.add(j);

        finance.add(l);

        System.out.println(ceo.getInfo());

        getAllSubordinateInfo(ceo.getSubordinateInfo());



    }

    /**遍历所有的树枝节点,打印出信息*/
    private static void getAllSubordinateInfo(ArrayList subordinateList){
        int length = subordinateList.size();
        for(int m=0;m<length;m++){ //定义一个ArrayList长度，不要在for循环中每次计算
            Object s = subordinateList.get(m);
            if(s instanceof Leaf){ //是个叶子节点，也就是员工
                ILeaf employee = (ILeaf)s;
                System.out.println(((Leaf) s).getInfo());
            }else{
                IBranch branch = (IBranch)s;
                System.out.println(branch.getInfo());
                //再递归调用
                getAllSubordinateInfo(branch.getSubordinateInfo());
            }
        }
    }

}
