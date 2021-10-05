package T05_DesignMode.T04_Multition;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/10/4 19:59
 * @description
 * @editUser hx
 * @editTime 2021/10/4 19:59
 * @editDescription 先把连个皇帝定义出来
 */
public class Emperor {

    /**最多只能由两个皇帝*/
    private static int maxNumOfEmperor = 2;

    /**皇帝叫什么名字*/
    private static ArrayList emperorInfoList = new ArrayList(maxNumOfEmperor);

    /**装皇帝的列表*/
    private static ArrayList emperorList = new ArrayList(maxNumOfEmperor);

    /**正在被人尊称的是哪个皇帝*/
    private static int currentNumOfEmpperor = 0;

    /**先把两个皇帝生产出来,*/
    static {
        for (int i = 0; i < maxNumOfEmperor; i++) {
            emperorInfoList.add(new Emperor());
        }
    }


    private Emperor() {}


    private Emperor(String info){
        emperorInfoList.add(info);
    }

    /**随机拉出来一个皇帝*/
    public static Emperor getInstance() {
        Random random = new Random();
        //随机拉出来一个皇帝,
        currentNumOfEmpperor = random.nextInt(maxNumOfEmperor);

        return (Emperor) emperorList.get(currentNumOfEmpperor);
    }


    public static void emperorInfo() {
        System.out.println(emperorInfoList.get(currentNumOfEmpperor));
    }






}
