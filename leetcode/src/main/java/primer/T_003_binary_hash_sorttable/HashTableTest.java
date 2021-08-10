package primer.T_003_binary_hash_sorttable;

import javax.transaction.TransactionRequiredException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/8/10 7:05
 * @option
 * @description
 * @editUser hx
 * @editTime 2021/8/10 7:05
 * @editDescription
 */
public class HashTableTest {

    static class Node {
        public int value;

        public Node(int v) {
            value = v;
        }
    }

    public static void main(String[] args) {
        HashMap<String, String> hashMap = new HashMap<String, String>();

        hashMap.put("hanxiao", "吃饭");
        System.out.println(hashMap.containsKey("hanxiao"));
        System.out.println(hashMap.get("hanxiao"));

        hashMap.put("hanxiao", "睡觉");
        System.out.println(hashMap.get("hanxiao"));
        System.out.println(hashMap.containsKey("hanxiao"));

        System.out.println("===============String =================");
        //引用的传递
        String test1 = "hanxiao";
        String test2 = "hanxiao";
        System.out.println(hashMap.get(test1));
        System.out.println(hashMap.get(test2));


        System.out.println("+================Integer=====================");
        HashMap<Integer, String> map2 = new HashMap<Integer, String>();
        Integer integer1 = 123456;
        Integer integer2 = 123456;
        //这两个比较的是内存地址, 比较之后结果为false
        System.out.println(integer1 == integer2);

        //map中这里的key值比较的值, 而不是内存地址, 所以只要值相等就可以了. 都可以取出来数据
        //hash表里全部按值传递, 基础类型有用
        map2.put(1234567, "我是1234567");
        System.out.println(map2.get(test1));
        System.out.println(map2.get(test2));


        //这里自定义的类型都是只关心你的 内存地址 作为key 东西有没有加进来()
        //key
        System.out.println("====================NOde 自定义引用类型=============================");
        Map<Node, String> stringMap = new HashMap<Node, String>();
        Node node1 = new Node(1);
        Node node2 = new Node(1);
        stringMap.put(node1, "wo shi node");
        //stringMap.put(node2, "wo shi node");
        System.out.println(stringMap.containsKey(node1));//true
        System.out.println(stringMap.containsKey(node2));//false


        System.out.println("=============================TreeMap====================================");
        TreeMap<Integer, String> treeMap = new TreeMap<Integer, String>();
        treeMap.put(2, "我是2");
        treeMap.put(22, "我是2");
        treeMap.put(6, "我是2");
        treeMap.put(8, "我是2");
        treeMap.put(9, "我是2");
        treeMap.put(1, "我是2");

        System.out.println(treeMap.containsKey(6));
        System.out.println(treeMap.containsKey(66));

        treeMap.remove(6);
        System.out.println(treeMap.containsKey(6));
        System.out.println(treeMap.get(6));
        //最大最小
        System.out.println(treeMap.lastKey());
        System.out.println(treeMap.firstKey());

        System.out.println("------------------");
        //<= 6, 距离6最近 告诉我
        System.out.println(treeMap.floorKey(6));
        //<=7, 距离7 最近的告诉我
        System.out.println(treeMap.floorKey(7));
        //>=8 距离8最近的数字告诉我
        System.out.println(treeMap.ceilingKey(8));
        //>=8.距离8最近的数字告诉我
        System.out.println(treeMap.ceilingKey(9));


        //这里的node 必须是可以比较的东西, 只能在 后面传一个比较器, 否则会报错
        //HashTableTest$Node cannot be cast to java.lang.Comparable
        TreeMap<Node,String> treeMap1 = new TreeMap<Node, String>();
        Node node3 = new Node(3);
        Node node4 = new Node(3);

        treeMap1.put(node3,"woshi");
        treeMap1.put(node4, "woshi");








    }

}
