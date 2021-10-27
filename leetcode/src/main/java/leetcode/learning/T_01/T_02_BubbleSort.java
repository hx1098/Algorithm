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
public class T_02_BubbleSort {

    //8,2,4,1,5
    //第一次排序  2,4,1,5,8  两个两个的一次进行排序,
    //第二次排序  2,1,4,5,8
    /**冒泡排序*/
    public static void bubble(int[] arr) {
        /*外层控制循环几次, 因为是两两相互进行比较, 两个数比较一次, 三个数的就是比较两次, 所以要(length - 1)*/
        for (int i = 0; i < arr.length -1; i++) {
            //内层进行比较大小, 每一次的最后一步都会将最大值放在最后面,
            //第一次最后一次比较后 产生一个最大值, 第二次就少一次比较, 坐标向前推一个, 来到倒数第二个
            //第二次最后一次比较厚, 产生第二大值, 第三次就少一次比较, 坐标在向推送一个, 来到倒数第三个
            //.....依次类推
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr,j,j+1);
                }
            }
        }
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
