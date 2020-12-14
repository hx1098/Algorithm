package primer;

/**
 * @author hx   <br>
 * @Title: <br>
 * @Description: <br>
 * @date 2020/12/13 23:16
 * 打印32位数字的小程序.
 */
public class T_001 {
    /*int 类型的数据在java中的类型是32位的. */
    public static void main(String[] args) {
        int num = 783456348;
        print(num);
    }
    public static void print(int num){
        for (int i = 31; i >= 0; i--) {
            System.out.println((num & (1 << i))==0 ? "0" : 1);
        }
    }
}
