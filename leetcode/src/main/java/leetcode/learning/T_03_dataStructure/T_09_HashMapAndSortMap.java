package leetcode.learning.T_03_dataStructure;

import java.util.HashMap;
import java.util.TreeMap;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/11/29 7:14
 * @description
 * @editUser hx
 * @editTime 2021/11/29 7:14
 * @editDescription  hash表和有序表
 */
public class T_09_HashMapAndSortMap {

    public static class Node {
        private int val;

        public Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {

        Integer a = 100;
        Integer b = 100;
        HashMap<Integer, String> stringHashMap = new HashMap<>();
        stringHashMap.put(a, "我是apush进来的数据");
        System.out.println(stringHashMap.containsKey(b));//true


        System.out.println("==============================================");
        Node node1 = new Node(1);
        Node node2 = new Node(1);
        HashMap<Node, String> nodeStringHashMap = new HashMap<>();
        nodeStringHashMap.put(node1, "我是node传进来的数据");

        System.out.println(nodeStringHashMap.containsKey(node2));

        //综上所述, 原生的string, integer, double等数据结构, 都会按照值来进行传递, 但是非原生的类型就会按照 "引用" 传递来进行


        System.out.println("============================================================================");
        TreeMap<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(3, "我是3");
        treeMap.put(2, "我是2");
        treeMap.put(5, "我是5");
        treeMap.put(9, "我是9");
        treeMap.put(19, "我是19");
        treeMap.put(1, "我是1");

        System.out.println(treeMap.containsKey(1));
        System.out.println(treeMap.containsKey(100));



        System.out.println(treeMap.firstKey());
        System.out.println(treeMap.ceilingKey(4));


        System.out.println("----------------------------");
        //<= 4 的key
        System.out.println(treeMap.floorKey(4));
        //>=4 最近的key
        System.out.println(treeMap.ceilingKey(4));

    //    treeMap的key值只能是string, integer, double等这一类的基础数据结构, 否则会报错

        //<editor-fold desc="这里是演示的报错代码">
        TreeMap<Node,String> map2 = new TreeMap<>();
        map2.put(node1, "234");
        //T_09_HashMapAndSortMap$Node cannot be cast to java.lang.Comparable
        //</editor-fold>
    }
}
