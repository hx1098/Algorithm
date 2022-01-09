package primer;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/10/7 20:28
 * @description
 * @editUser hx
 * @editTime 2021/10/7 20:28
 * @editDescription
 */
public class Test {

    //https://www.cnblogs.com/wxgblogs/p/5635099.html
    public static void main(String[] args) {
        String s3 = new String("1") + new String("1");
        s3.intern();
        String s4 = "11";
        //s3.intern();  这一行放在下面和放在上面是不一样的,
        System.out.println(s3 == s4);
        System.out.println(s3.hashCode());
        System.out.println(s4.hashCode());
    }


    @org.junit.Test
    public void test1(){
        String s3 = new String("1") + new String("1");
        s3.intern();
        String s4 = "11";
        System.out.println(s3 == s4);
        System.out.println(s3.hashCode());
        System.out.println(s4.hashCode());
    }




    

}
