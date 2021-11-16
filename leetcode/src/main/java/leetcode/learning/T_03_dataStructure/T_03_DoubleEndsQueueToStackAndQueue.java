package leetcode.learning.T_03_dataStructure;


/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/11/16 6:36
 * @description
 * @editUser hx
 * @editTime 2021/11/16 6:36
 * @editDescription 双端队列
 */
public class T_03_DoubleEndsQueueToStackAndQueue {

    /**
     * 先定义出来链表的结构
     */
    public static class Node<T> {
        public T value;
        public Node<T> last;//上一个值
        public Node<T> next;//下一个值

        public Node(T data) {
            value = data;
        }
    }


    static class DoubleEndQueue<T> {
        public Node<T> head;
        public Node<T> tail;

        /**向队列中添加数据,
         * 心中要有一个模型, 队列的特点: 1.先进先出, 2.第一个数据, 第二个数据的指针指向变换
         * 第一次  null <- a -> null
         *        此时的a 的next指针指向null, a的last指针也是指向的null
         *
         * 第一次 null <- b -> <- a -> null  (这里的a指向b, b也指向a, )
         *        此时a的last指向b,  b的next指向a, b的last指向null,
         */
        public void addFromHead(T value) {
            Node<T> cur = new Node<T>(value);
            if (head == null) {
                head = cur;
                tail = cur;
            } else {
                cur.next = head;
                head.last = cur;
                head = cur;
            }
        }



    }


}
