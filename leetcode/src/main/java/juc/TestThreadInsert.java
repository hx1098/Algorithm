package juc;

import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2022/2/23 15:10
 * @description
 * @editUser hx
 * @editTime 2022/2/23 15:10
 * @editDescription
 */
public class TestThreadInsert {

    public interface Executor<T extends List> {
        void runAction(T t);
    }


    /**
     *
     * @param action 返回的截取数据表  自行写操作方法
     * @param dataList  总数据表
     * @param threadCount 需要的线程总数  0 < threadCount < 11
     * @param <F> 指定数据表泛型
     */
    public static <F> void save(Executor<? super List<F>> action, List<F> dataList, int threadCount) {
        if (CollectionUtils.isEmpty(dataList)) {
            return;
        }
        if (threadCount < 1 || threadCount > 10) {
            return;
        }
        int threadSize = dataList.size() / (threadCount - 1);
        // 总数据条数
        int dataSize = dataList.size();
        // 分段数
        int threadNum = dataSize / threadSize + 1;
        // 创建一个线程池
        ExecutorService exec = Executors.newFixedThreadPool(threadCount);
        // 定义一个任务集合
        List<F> cutList = null;
        // 确定每条线程的数据
        try {
            for (int i = 0; i < threadNum; i++) {
                if (i == threadNum - 1) {
                    cutList = dataList.subList(threadSize * i, dataSize);
                } else {
                    cutList = dataList.subList(threadSize * i, threadSize * (i + 1));
                }
                List<F> finalCutList = cutList;
                exec.execute(() -> {
                    action.runAction(finalCutList);
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭线程池
            exec.shutdown();
        }
    }

    public static void main(String[] args) {
        List<String> enrollStudentEntityList = new ArrayList<>();
        for (int i = 0; i < 190; i++) {
            enrollStudentEntityList.add(UUID.randomUUID().toString());
        }
        System.out.println("共获取到用户：" + enrollStudentEntityList.size());



        TestThreadInsert.save(cutList->{
            int j = 0;
            System.out.println(cutList.size());
            for (String s : cutList) {
                j++;
                System.out.println(Thread.currentThread().getName() + "   当前执行到" +s + "  剩余：" + (cutList.size() - j));
                System.out.println("23234");
            }

        },enrollStudentEntityList,20);


    }



}
