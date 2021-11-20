package leetcode.learning.T_03_dataStructure;


/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/11/16 6:36
 * @description
 * @editUser hx
 * @editTime 2021/11/16 6:36
 * @editDescription 双向链表实现栈和队列
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

        /**
         * 向队列中添加数据,
         * 心中要有一个模型, 队列的特点: 1.先进先出, 2.第一个数据, 第二个数据的指针指向变换
         * 第一次  null <- a -> null
         * 此时的a 的next指针指向null, a的last指针也是指向的null
         * <p>
         * 第一次 null <- b -> <- a -> null  (这里的a指向b, b也指向a, )
         * 此时a的last指向b,  b的next指向a, b的last指向null,
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


        /**
         * 向队列中删除数据
         * 心中要有一个模型, 队列的特点: 1.先进先出, 2.第一个数据, 第二个数据的指针指向变换
         * <p>
         * 边界条件
         * 0.如果队列本来就是空, return
         * <p>
         * 第一次 null <- b -> <- a -> null  (这里的a指向b, b也指向a, )
         * 只用把b 的next 指针指向null, a 的next指针指向null,
         */
        public T popHead() {
            if (head == null) {
                return null;
            }
            Node<T> cur = head;
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                head = head.next;
                cur.next = null;
                head.last = null;
            }
            return cur.value;
        }


        public T popFromBottom() {
            if (head == null) {
                return null;
            }
            Node<T> cur = head;
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                tail = tail.last;

            }
            return cur.value;
        }


        /**
         * 如果头节点的是null, 则该链表一定是空的.
         */
        public boolean isEmpty() {
            return head == null;
        }
    }

    public static class MyStack<T> {
        private DoubleEndQueue<T> queue;

        public MyStack() {
            queue = new DoubleEndQueue<>();
        }

        public void push(T value) {
            queue.addFromHead(value);
        }

        public T pop() {
            return queue.popHead();
        }
        public boolean isEmpty() {
            return queue.isEmpty();
        }
    }

    public static class MyQueue<T> {
        private DoubleEndQueue<T> queue;

        public MyQueue() {
            queue = new DoubleEndQueue<>();
        }

        public void push(T value) {
            queue.addFromHead(value);
        }
        public T poll() {
            return queue.popFromBottom();
        }
        public boolean isEmpty() {
            return queue.isEmpty();
        }
    }

    public static boolean isEqual(Integer o1, Integer o2) {
        if (o1 == null && o2 != null) {
            return false;
        }
        if (o1 != null && o2 == null) {
            return false;
        }
        if (o1 == null && o2 == null) {
            return true;
        }
        return o1.equals(o2);
    }

    // todo-hx 2021/11/20 9:25 编写测试类




}
