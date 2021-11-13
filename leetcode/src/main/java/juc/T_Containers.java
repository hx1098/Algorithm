package juc;

import lombok.SneakyThrows;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/11/12 12:06
 * @description
 * @editUser hx
 * @editTime 2021/11/12 12:06
 * @editDescription 写一个固定容量同步容器，拥有put和get方法，以及getCount方法，
 * 能够支持2个生产者线程以及10个消费者线程的阻塞调用
 */
public class T_Containers<T> {

  final private LinkedList<T> list = new LinkedList<>();
    //**最多10个元素
    private final int max = 10;
    private int count = 0;

    /*
    *//**//**//**//**
     * 1.找临界值, 如果存入的数量 == max, 就英嘎停止了
     * 2.否则就进行相加的操作, 同时count的数量增加, 唤醒消费者线程
     * */
    @SneakyThrows
    public synchronized void put(T t) {
        while (list.size() == max) {
            this.wait();
        }
        list.add(t);
        ++count;
        this.notifyAll();
    }

    /*
     * 1.零界点， 当list的size减小到0时候, 需要进行停止弹出元素
     * 2.否则, 将第一个元素进行删除, 同时count的数量进行－1, 唤醒所有线程, 将值进行返回出去.
     * */
    @SneakyThrows
    public synchronized T get()  {
        T t = null;
        while (list.size() == 0) {
            this.wait();
        }
        t = list.removeFirst();
        count--;
        this.notifyAll();
        return t;
    }


    public static void main(String[] args) {
        T_Containers<String> c = new T_Containers<>();

        /**启动消费者县线程*/
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 5; j++) System.out.println(c.get());
            }, "c" + i).start();
        }

        //TimeUnit.SECONDS.sleep(2);

        /**启动生产者线程*/
        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                for (int j = 0; j < 25; j++) c.put(Thread.currentThread().getName() + " :" + j);
            }, "p" + i).start();
        }

    }



}
