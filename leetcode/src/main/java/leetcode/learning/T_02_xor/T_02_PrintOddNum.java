package leetcode.learning.T_02_xor;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/11/1 7:18
 * @description
 * @editUser hx
 * @editTime 2021/11/1 7:18
 * @editDescription 题目:
 * 一个数组中有一种数出现了奇数次, 其他数都出现了偶数次, 如何找到并打印这种数?
 * <p>
 * 思路1: 利用map进行hash碰撞, 有的值加1, 计算出哪个是奇数的值
 * 思路2: 利用 ^ 运算, 奇数的一定回返回这个数, 偶数的一定会返回0
 * <p>
 * 异或运算是一个无进位运算, 就是说两个都为1, 则为0, 上一位不会加1, 0还是为0.
 */
public class T_02_PrintOddNum {


    /**
     * 思路
     * 0. 边界条件, arr == null 或者 arr.length == 0 return;
     * 1. 利用 ^ 运算, 如果两个数存在偶数个, 则最后异或出的数据一定是0, 如果存在奇数个, 则异或出来的数一定是那个奇数的 数据
     */
    public static int searchOddNum(int[] arr) {
        if (arr == null || arr.length == 0) return 0;
        //    正片开始:
        for (int i = 1; i < arr.length; i++) {
            arr[0] ^= arr[i];
        }
        return arr[0];
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 3,3, 7};
        System.out.println(searchOddNum(arr));;
    }

}
