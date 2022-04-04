package leetcode.leetcode;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2022/4/3 13:39
 * @description
 * @editUser hx
 * @editTime 2022/4/3 13:39
 * @editDescription
 */
public class T_003_MathRandom {

    // mathRandom 是等概率的
    public static void main(String[] args) {
        int testTImes = 100000;
        int count = 0;
        for (int i = 0; i < testTImes; i++) {
            if (Math.random() < 0.75) {
                count++;
            }
        }
        System.out.println((double) count/(double) testTImes);


        count = 0;
        for (int i = 0; i < testTImes; i++) {
            if (Math.random() * 8 < 4) {
                count++;
            }
        }
        System.out.println((double) count / (double) testTImes);


        int[] arr = new int[9];
        int k = 9;
        for (int i = 0; i < testTImes; i++) {
            int ans = (int) (Math.random() * k);
            arr[ans]++;
        }
        for (int i = 0; i < k; i++) {
            System.out.println(i + "这个数出现了 " + arr[i] + " 次");
        }
    }

}
