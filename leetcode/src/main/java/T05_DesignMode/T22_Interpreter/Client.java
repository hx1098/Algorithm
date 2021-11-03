package T05_DesignMode.T22_Interpreter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.channels.FileChannel;
import java.util.HashMap;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/11/3 14:44
 * @description
 * @editUser hx
 * @editTime 2021/11/3 14:44
 * @editDescription
 */
public class Client {

    /**运行四则运算*/
    public static void main(String[] args) throws IOException {
        String expStr = getExpStr();
        HashMap<String, Integer> var = getValue(expStr);

        //    赋值
        Calculator cal = new Calculator(expStr);
        System.out.println("运行结果为:" + expStr + " = " + cal.run(var));
    }



    /**获取表达式*/
    private static String getExpStr() throws IOException {
        System.out.println("请输入表达式: ");
        return (new BufferedReader(new InputStreamReader(System.in))).readLine();
    }
    /**获取值映射*/
    private static HashMap<String, Integer> getValue(String expStr) throws IOException {
        HashMap<String, Integer> hashMap = new HashMap<>();

        //    解析有几个参数要传递
        for (char ch : expStr.toCharArray()) {
            if (ch != '+' && ch != '-') {
                if (!hashMap.containsKey(String.valueOf(ch))) {
                    System.out.println("请输入" + ch +"的值");
                    String in = (new BufferedReader(new InputStreamReader(System.in))).readLine();
                    hashMap.put(String.valueOf(ch), Integer.valueOf(in));
                }
            }
        }
        return hashMap;
    }



}
