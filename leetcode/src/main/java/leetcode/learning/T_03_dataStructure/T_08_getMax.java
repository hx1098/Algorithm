package leetcode.learning.T_03_dataStructure;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/11/24 13:42
 * @description
 * @editUser hx
 * @editTime 2021/11/24 13:42
 * @editDescription 获取max 中的最大值, 使用二分递归的手法
 *
 * 加入arr中有五条数据
 * 递归的图示如下
 *                 1.f(0~3)
 *           f(0~1)        f(2~3)
 *       f(0)  f(1)        f(2) f(3)
 *
 *  递归的图如上, 计算f(0~3)的最大值依赖于 f(0~1)  f(2~3)
 *  但是此时的 f(0~1)  f(2~3) 结果 依赖于   f(0)  f(1)        f(2) f(3)
 *
 */
public class T_08_getMax {

    public static Integer getMax(int[] arr) {
       return possess(arr, 0, arr.length - 1);
    }

    private  static int possess(int[] arr, int L, int R) {
        //如果L == R 则说明拆分到了只剩一个数据了, 直接返回就可以了.
        if (L == R) {
            return arr[L];
        }
        // 1, 2, 3, 5,......2^32, 防止int类型数据溢出.
        int middle = L + ((R - L) >> 1);
        int leftMax = possess(arr, 0, middle);
        int rightMax = possess(arr, middle + 1, R);
        return Math.max(leftMax, rightMax);
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 87, 34, 23, 67, 18};
        Integer b = getMax(arr);
        System.out.println(b);
    }



}
