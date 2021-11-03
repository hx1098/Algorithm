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
public class T_01_Xor {


    public static void main(String[] args) {

        System.out.println("========= ^ =============");
        int a =10;
        int b = 6;
        System.out.println(a);
        System.out.println(b);
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println(a);
        System.out.println(b);

        System.out.println("--------a^b----------");
        System.out.println(a^b);
        //a   0000 1010   = 10
        //b   0000 0110   = 6
        //a^b 0000 1100   = 12



        System.out.println("========== & ============");
        // 取反加1就是自己的相反数
        int c = 7;
        System.out.println( ~c + 1 );
    }

}
