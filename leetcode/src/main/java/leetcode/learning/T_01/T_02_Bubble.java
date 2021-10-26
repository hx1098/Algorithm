package leetcode.learning.T_01;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/10/25 22:18
 * @description
 * @editUser hx
 * @editTime 2021/10/25 22:18
 * @editDescription 冒泡排序 在于找到最大值
 */
public class T_02_Bubble {

    public static void bubble(int[] arr) {

    }

    /**两个数进行交换*/
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {10, 8, 4, 9};
        bubble(arr);
        for (int i : arr) {
            System.out.print(i);
        }
    }


}
