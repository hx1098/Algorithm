package leetcode.learning.T_02_xor;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/11/2 6:47
 * @description
 * @editUser hx
 * @editTime 2021/11/2 6:47
 * @editDescription 如何吧一个int类型的数,提取出二进制位最左侧的1出来
 */
public class T_03_printNumOne {

    public static void main(String[] args) {
        int a = 7;

        // a    0000 0111  目标值是第一位的1
        // ~a   1111 1000
        //-a    1111 1001
        //a&-a  0000 0001

        System.out.println(a & -a);
        System.out.println(a & (~a +1));


    }

}
