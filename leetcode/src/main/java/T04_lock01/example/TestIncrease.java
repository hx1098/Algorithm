package T04_lock01.example;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2022/2/1 11:10
 * @description
 * @editUser hx
 * @editTime 2022/2/1 11:10
 * @editDescription
 */
public class TestIncrease {

    public static void main(String[] args) {
        int i = 8;
        i = i++;
        //i = ++i;
        System.out.println(i);


    }

}
