package T04_lock01;


import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * 找出数组中重复的数字。
 * <p>
 * <p>
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 */
public class T_002_findRepateNums {

    //region ========== 注释: 自己的解法==========


    /**
     * 哎, 用到的上次的方法, 但是没有考虑时间和空间的要求, 虽然也能运行, 也能跑, 但是.....
     *
     * @param arr
     * @return
     */
    public static List<Integer> getRepeate(int[] arr) {
        //定义一个变量, 来存储重复的结果
        ArrayList<Integer> result = new ArrayList<Integer>(8);
        Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < arr.length; i++) {
            if (hashMap.containsKey(arr[i])) {
                result.add(arr[i]);
            }
            hashMap.put(arr[i], i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 1, 4};
        //List<Integer> list = getRepeate(arr);
        //list.forEach(System.out::println);
        int repeatNumber = findRepeatNumber(arr);
        System.out.println(repeatNumber);
        boolean b = true;


    }
    //endregion

    //region ========== 注释: leetcode 群友解法, 膜拜一下先==========
    public static int findRepeatNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    res = nums[i];
                    return res;
                }
                int temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
            }
        }
        return res;


    }

    private static class MyCall implements Callable<String> {
        @Override
        public String call() throws Exception {
            System.out.println("call 执行了....");
            return "call";
        }
    }


    @Test
    public void test134(){
        Callable<String> stringCallable = new MyCall();
        FutureTask<String> task = new FutureTask<>(stringCallable);
        new Thread(task).start();
    }


    //endregion

}
