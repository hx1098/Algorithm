package leetcode;

import java.util.HashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
*
* 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。

你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。

你可以按任意顺序返回答案。


示例 1：

输入：nums = [2,7,11,15], target = 9
输出：[0,1]
解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
示例 2：

输入：nums = [3,2,4], target = 6
输出：[1,2]
示例 3：

输入：nums = [3,3], target = 6
输出：[0,1]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/two-sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class T_001 {

    /**
     * 思路: 既然是给定的两数之和是 target, 那就直接减去, 看看哪个数字在map中, 如果存在就直接返回.
     */
    public static int[] twoSum(int[] arr, int target) {
        int[] temp = new int[2];
        /*key 为值, value为下标*/
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < arr.length; i++) {
            if (hashMap.containsKey(arr[i])) {
                arr[0] = i;
                arr[1] = hashMap.get(arr[i]);
            }
            hashMap.put(target - arr[i], i);
            return temp;
        }
        return null;
    }

    public static void main(String[] args) {
       /* int[] arr = {1, 4, 2, 9, 3, 5};
        int[] ints = twoSum(arr, 10);
        for (int anInt : ints) {
            System.out.println(anInt);
        }*/
    }
}
