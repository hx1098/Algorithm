package T_08_Mysql;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2022/2/14 17:18
 * @description
 * @editUser hx
 * @editTime 2022/2/14 17:18
 * @editDescription
 */
public class test {

    static boolean foo(char c) {
        System.out.println(c);
        return true;
    }
   public static void main(String[] args) {
       int i = 0;
       for (foo('a'); foo('b') && (i < 2); foo('c')) {
           i++;
           foo('d');
       }
   }

}
