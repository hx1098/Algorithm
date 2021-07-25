package primer.T_003_binary_hash_sorttable;

import java.util.Arrays;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/7/13 14:09
 * @option 二分法, 
 * @description
 * @editUser hx
 * @editTime 2021/7/13 14:09
 * @editDescription
 */
public class T_002_binary_hash_sorttable {


    /**
     * 有序的数组, 二分查找数据
     *
     * @param arr 要查找的数组
     * @param num 要查找的值
     * @return
     */
    public static boolean find(int[] arr, int num) {
//        处理边界值
        if (arr == null || arr.length == 0) {
            return false;
        }
//        分析:
//        二分查找, 其实就是将一个arr从中间分开, 最左侧是最小的0, 左右侧是最大的数, 选出一个中间的数值,
//        0.如果查找的值刚好是中间值, 就直接返回就行.
//        1.如果中间值 大于 查找值, 右侧的要舍弃, 从左侧开始查找, 起始值不改变, 终止值变成 middle -1
//        2.如果中间值 小于 查找值, 左侧的要舍弃, 从右侧开始查找, 终止值不改变, 其实值变成 middle +1
//        3.临界值: 左侧的数据大于等于 右侧的数据时候, 紧要停止了
        int L = 0;
        int R = arr.length - 1;
        while (L <= R) {
            int middle = (L + R) / 2;
            if (arr[middle] == num) {
                return true;
            } else if (arr[middle] < num) {
                L = middle + 1;
            } else {
                R = middle - 1;
            }
        }
        return false;
    }


    // for test
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }
    // for test
    public static boolean test(int[] sortedArr, int num) {
        for (int cur : sortedArr) {
            if (cur == num) {
                return true;
            }
        }
        return false;
    }
    //    for test
    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 10;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr = generateRandomArray(maxSize, maxValue);
            Arrays.sort(arr);
            int value = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
            if (test(arr, value) != find(arr, value)) {
                System.out.println("出错了！");
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
    }


}
