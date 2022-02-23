package leetcode.learning.T_09_PrefixTree;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2022/2/18 7:03
 * @description
 * @editUser hx
 * @editTime 2022/2/18 7:03
 * @editDescription 前缀树
 */
public class T_01_PrefixTree {

    /**前缀树节点*/
    public static class Node1 {
        public int pass;//路径经过的点
        public int end;//路径结束的点
        public Node1[] nexts;
        public Node1() {
            pass = 0;
            end = 0;
            nexts = new Node1[26];//26个字母
        }
    }

    public static class Trie1 {
        private Node1 root;

        public Trie1() {
            root = new Node1();
        }

        public void insert(String word) {
            if(word == null) return;

            char[] chars = word.toCharArray();
            Node1 node = root;
            node.pass++;
            int index = 0;
            for (int i = 0; i < chars.length; i++) {//遍历字符
                index = chars[i] - 'a';//确定走那一条路
                if (node.nexts[index] == null) {
                    node.nexts[index] = new Node1();
                }
                node = node.nexts[index];
                node.pass++;
            }
            node.end++;
        }

        public void delete(String word) {
            if (search(word) != 0) {
                char[] charArray = word.toCharArray();
                Node1 node = root;
                node.pass--;
                int index = 0;
                for (int i = 0; i < charArray.length; i++) {
                    index = charArray[i] - 'a';
                    if (--node.nexts[index].pass == 0) {
                        node.nexts[index] = null;
                        return;
                    }
                    node = node.nexts[index];
                }
                node.end--;
            }
        }

        // word 这个词出现过几次
        private int  search(String word) {
            if (null == word) return 0;

            char[] charArray =word.toCharArray();
            Node1 node = root;
            int index = 0;
            for (int i = 0; i < charArray.length; i++) {
                index = charArray[i] - 'a';
                if (node.nexts[index] == null) return 0;

                node = node.nexts[index];
            }

            return node.end;
        }

        //所有加入的字符串中, 有几个是以pre这个字符串开头的.
        public int prefixNumber(String pre) {
            if (pre == null) {
                return 0;
            }
            char[] chr = pre.toCharArray();
            Node1 node = root;
            int index = 0;
            for (int i = 0; i < chr.length; i++) {
                index = chr[i] - 'a';
                if (node.nexts[index] == null) {
                    return 0;
                }
                node = node.nexts[index];
            }
            return node.pass;
        }

    }


}
