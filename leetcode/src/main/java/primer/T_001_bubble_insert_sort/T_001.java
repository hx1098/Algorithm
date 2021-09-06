package primer.T_001_bubble_insert_sort;

import jdk.internal.org.objectweb.asm.tree.MethodInsnNode;
import org.junit.Test;

import java.io.PrintStream;
import java.util.jar.JarEntry;

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


    @Test
    public void test1() {
        Integer test = 1;
        print(test);
        /*向左移动1个位置*/
        print(test << 1);
        /*向左移动八个位置*/
        print(test << 8);
        System.out.println("================================");

        int a = 2;
        int b = 3;
        print(a);
        print(b);
        int c = a & b;
        print(c);
        System.out.println(c);

    }

    /**
     * @param
     * @return
     * @author hx
     * @date 2021/6/1 15:38
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
        int[] arr = {9, 3, 5, 2, 4, 6};
        bubbo(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }


    }

    /**
     * 打印整形的32位二进制数据
     * 位移运算符, 第一次 左移 31位,
     * 第二次 左移 30位,
     *
     * @param num
     */
    public static void print(int num) {
        for (int i = 31; i >= 0; i--) {
            System.out.print((num & (1 << i)) == 0 ? "0" : 1);
        }
        System.out.println();
    }


    @Test
    public void test18() {
        print(-11);
    }

    /**
     * 打印数组
     *
     * @param arr
     */
    public static void printArr(int[] arr) {
        for (int i : arr) {

            System.out.print(i);
        }
    }


    /**
     * 选择排序
     * 用一个变量值记录最小值的下标,
     * 思路: 第一遍: 找出最小的值   比较次数: arr.size 个数  最后交换位置
     * 第二遍: 找出最小的值,  比较次数: arr.lenth-1    最后交换位置
     */
    @Test
    public void selectSort() {
        int arr[] = {5, 4, 2, 1, 3};
        printArr(arr);

        for (int j = 0; j < arr.length; j++) {
            System.out.println();
            int min = j;
            for (int i = j + 1; i < arr.length; i++) {//每一次只找出最小的值
                if (arr[min] > arr[i]) {
                    min = i;
                }
            }
            int tem = arr[j];
            arr[j] = arr[min];
            arr[min] = tem;
            printArr(arr);
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
     *
     * @param arr
     * @param a
     * @param b
     * @return
     */
    public static int[] swap1(int[] arr, int a, int b) {
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
                    swap1(arr, j, j + 1);
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

        int c = -4;
        System.out.println(-4 >>> 1);
        //'00000000 00000000 00000000 00000000'
    }

    /**
     * 10的阶乘
     */
    public int test1(int num) {
        int temp = 0;
        int cusor = 1;
        for (int i = 1; i <= num; i++) {
            cusor = cusor * i;
            temp = temp + cusor;
        }
        return temp;
    }

    @Test
    public void test00() {
        System.out.println(test1(3));
    }

}
