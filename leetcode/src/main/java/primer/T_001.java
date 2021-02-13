package primer;

/**
 * @author hx   <br>
 * @Title: <br>
 * @Description: <br>
 * @date 2020/12/13 23:16
 * 打印32位数字的小程序.
 * 冒泡排序
 * 选择排序 选择一个
 *
 */
public class T_001 {
    /**
     * int 类型的数据在java中的类型是32位的
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
    public static void print(int num){
        for (int i = 31; i >= 0; i--) {
            System.out.print((num & (1 << i))==0 ? "0" : 1);
        }
        System.out.println();
    }

    /**
     * 选择排序
     *
     * @param arr
     */
    public static void selectSort(int[] arr){
        int N = arr.length;
        if (arr == null || N < 2){ return; }
        for (int i = 0; i < N; i++) {

        }
    }

    /**
     * 冒泡排序:
     * intarr[] = {4,6,9,2,7,1,7,3,7,3};
     * 第一次排序:  intarr[0]位置上和intarr[1]比较大了右移,小的不动,  intarr[1]位置上和intarr[2]比较, intarr[2]位置上和intarr[3]...  n-1次比较   最后一个是最大的了不用比较了.
     * 第一次排序:  intarr[0]位置上和intarr[1]比较大了右移,小的不动,  intarr[1]位置上和intarr[2]比较, intarr[2]位置上和intarr[3]...  n-2次比较   最后一个是最大的了不用比较了.
     *  .........
     * @param arr
     * @return
     */
    public static void bubbo(int[] arr){
        int N = arr.length;
        for (int i = 0; i < N; i++) {//控制循环次数
            for (int j = 0; j < i; j++) { //内层循环控制比较次数
                if(arr[j] > arr[j+1]){
                   arr =  swap(arr,j,j+1);
                }
            }
        }
    }
     // int[] arr = {9,3,5,2,4,6};
    /*两两数据交换*/
    public static int[] swap(int[] arr,int a,int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
        return arr;
    }
}
