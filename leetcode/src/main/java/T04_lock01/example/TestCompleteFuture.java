package T04_lock01.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/11/15 10:43
 * @description
 * @editUser hx
 * @editTime 2021/11/15 10:43
 * @editDescription
 */
public class TestCompleteFuture {

    public static int i = 0;


    static CompletableFuture<String> findCount(String accountId) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + ":start!");
                Thread.sleep((++i) * 1000);
                System.out.println(Thread.currentThread().getName() + ":end!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "account" + accountId;
        });
    }


    public static void batchProcess(List<String> accountList) {
        //并行根据acount查找相应的account
        List<CompletableFuture<String>> accountFindingFutureList = accountList
                .stream()
                .map(accountId -> findCount(accountId))
                .collect(Collectors.toList());


        //使用allof来表示所有的并行任务
        CompletableFuture<Void> allFutures = CompletableFuture
                .allOf(accountFindingFutureList.toArray(new CompletableFuture[accountFindingFutureList.size()]));


        //获取所有的结果.
        CompletableFuture<List<String>> finalResults  = allFutures
                .thenApply(v -> accountFindingFutureList.stream()
                        .map(accountFindingFuture -> accountFindingFuture.join())
                        .collect(Collectors.toList()));


        try {
            List<String> l = finalResults.get();
            System.out.println(l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        List<String> l = new ArrayList<String >();
        l.add("11111");
        l.add("22222");
        l.add("33333");
        batchProcess(l);
    }

}

