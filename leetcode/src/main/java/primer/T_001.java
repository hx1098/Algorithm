package primer;

import org.junit.Test;

/**
 * @author hx   <br>
 * @Title: <br>
 * @Description: <br>
 * @date 2020/12/13 23:16
 * 打印32位数字的小程序.
 * 冒泡排序
 * 选择排序 选择一个
 */
public class T_001 {


    /**
     * 位移运算符,每一个
     */
    @Test
    public void test1() {
        Integer test = 1;
        print(test);
        print(test << 1);
        print(test << 8);
    }

    /** 
     * @author hx
     * @date 2021/6/1 15:38
     * @param
     * @return
     * @desc
     */
    @Test
    public void test2() {
        int a = Integer.MAX_VALUE;
        System.out.println(a);
    }

    /**
     * int 类型的数据在java中的类型是32位的
     *
     * @param args
     */
    public static void main(String[] args) {
        int num = 783456348;
        print(11);

        System.out.println("========================");
        int[] arr = {9,3,5,2,4,6};
        bubbo(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }


    }

    /**
     * 打印整形的32位二进制数据
     * @param num
     */
    public static void print(int num) {
        for (int i = 31; i >= 0; i--) {
            System.out.print((num & (1 << i)) == 0 ? "0" : 1);
        }
        System.out.println();
    }

    @Test
    public void test18(){
        print(-11);
    }

    /**
     * 选择排序
     *
     * @param arr
     */
    public static void selectSort(int[] arr) {
        int N = arr.length;
        if (arr == null || N < 2) {
            return;
        }
        for (int i = 0; i < N; i++) {

        }
    }

    /**
     * 冒泡排序:
     * intarr[] = {4,6,9,2,7,1,7,3,7,3};
     * 第一次排序:  intarr[0]位置上和intarr[1]比较大了右移,小的不动,  intarr[1]位置上和intarr[2]比较, intarr[2]位置上和intarr[3]...  n-1次比较   最后一个是最大的了不用比较了.
     * 第一次排序:  intarr[0]位置上和intarr[1]比较大了右移,小的不动,  intarr[1]位置上和intarr[2]比较, intarr[2]位置上和intarr[3]...  n-2次比较   最后一个是最大的了不用比较了.
     * .........
     *
     * @param arr
     * @return
     */
    public static void bubbo(int[] arr) {
        int N = arr.length;
        for (int i = 0; i < N; i++) {//控制循环次数
            for (int j = 0; j < i; j++) { //内层循环控制比较次数
                if (arr[j] > arr[j + 1]) {
                    arr = swap(arr, j, j + 1);
                }
            }
        }
    }

    /*两两数据交换*/
    public static int[] swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
        return arr;
    }

    /**
     * 使用亦或进行两个数的交换
     * @param arr
     * @param a
     * @param b
     * @return
     */
    public static int[] swap1(int[] arr,int a, int b){
        arr[a] = arr[a] ^ arr[b];
        arr[b] = arr[a] ^ arr[b];
        arr[a] = arr[a] ^ arr[b];
        return arr;
    }

    /**
     * 冒泡排序复习
     */
    @Test
    public void te1st1() {
        /*冒泡排序思路
         *  1.最外层控制循环次数, 已经固定, 不会改变了, 就是arr.length
         *  2.内层控制比较次数
         *    第一次 j = 0, 比较次数: i-1 次,
         *    第二次 j = 1, 比较次数: i-2 次,
         *    第三次 j = 2, 比较次数: i-3 次,
         *
         */
        int arr[] = {9, 4, 1};
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap1(arr,j,j+1);
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ",");
        }

    }

    /*
    * 两个数值互相交换， 不使用第三个变量的情况下
    *
    * 任何一个数 亦或上自己本身, 都是0, 任何数疑惑上0都是自己本身
    *
    */
    @Test
    public void testaBB() {
        int a = 1;
        int b = 2;
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println(a);
        System.out.println(b);
    }



}
