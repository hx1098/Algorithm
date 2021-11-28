package leetcode.learning.T_03_dataStructure;

import java.util.HashMap;

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




    }

}
