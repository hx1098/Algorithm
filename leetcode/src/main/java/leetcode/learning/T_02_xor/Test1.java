package leetcode.learning.T_02_xor;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/11/1 7:06
 * @description
 * @editUser hx
 * @editTime 2021/11/1 7:06
 * @editDescription  无进位运算, 什么意思:  两个1相加进位为0 , 但是上一位不加1,
 */
public class Test1 {


    public static void main(String[] args) {

        int a =10;
        int b = 6;

        System.out.println(a);
        System.out.println(b);

        a = a ^ b;
        b = a ^ b;
        a = a ^ b;

        System.out.println(a);
        System.out.println(b);



    }

}
