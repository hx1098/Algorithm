package leetcode.learning.T_02_xor;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/11/2 9:37
 * @description
 * @editUser hx
 * @editTime 2021/11/2 9:37
 * @editDescription 题目: 一个数组中有两个数出现了奇数次, 其他数都出现了偶数次, 如何找到a,b这两个数?
 *
 * 思路:
 *
 * 1.先获取去这两个数的异或值 ==> (a,b出现了奇数次, 其他都是偶数次, 从头到尾异或之后就只剩下了a,b异或的值)
 * 2.temp 找到异或值 二进制位最右侧的1,(假如说是第三位) 并提取出来 ==> 则说明(此位置的数一定不相同, 异或运算的特点, 无进位运算),
 * 3.将数据分成两类, 一类是第三位为0的数据, 一类是第三位为1的数据, 一波数据肯定含有a, 另一波数据肯定含有b,
 * 4.分开之后, 这两波数分别异或一次, 就可以得到a,b的值了.
 */
public class T_04_PrintOddNums {

    /**
     * 查找到数组中出现奇数次的数据, 找到a,b这两个数
     */
    public static void searchNumbers(int[] arr) {
        // 找到 a^b的值,
        int temp = 0;
        for (int i = 0; i < arr.length; i++) {
            temp ^= arr[i];
        }
        System.out.println(temp);
        //  找到 a^b 二进制位最右侧的1, 此位置的数一定不相同, 异或运算的特点, 无进位运算
        int temp2 = temp & (~temp + 1);


        for (int i = 0; i < arr.length; i++) {
            //将数据分成两拨, 一波是tem2位置为0的数据, 一波不是为0的数据,
            //为0的一波数据, 偶数个数的数据,异或之后必然是0, 那剩下的就是a(b)这个假设的数据了, 妙哉!
            if ((arr[i] & temp2) == 0) {
                temp2 ^= arr[i];
            }
        }

        //temp2^temp 这句就相当于: temp2 = a, temp = a^b, 则, a^a^b = b
        System.out.println(temp2 + " b的值是: " + (temp2^temp));
    }

    public static void main(String[] args) {
        int[] arr = {2, 2, 2, 1, 1, 3, 3, 3};
        //  2  0000 0010
        //  3  0000 0011
        //  1  0000 0001
        //  2 ^ 3 = 1
        searchNumbers(arr);
    }

}
