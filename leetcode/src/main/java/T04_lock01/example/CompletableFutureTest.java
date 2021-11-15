package T04_lock01.example;

import lombok.SneakyThrows;
import org.junit.Test;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.stream.Collectors;

/**
 * @author hx
 * @createTime 2021/9/26 14:05
 * @version 1.0.0
 * @description
 * @editUser hx
 * @editTime 2021/9/26 14:05
 * @editDescription
 */
public class CompletableFutureTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> future = new CompletableFuture<>();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("CompletableFuture 可以监控这个任务的执行");
                future.complete("任务返回结果...");
            }
        }).start();

        //这里可以查看一个线程的返回结果.
        System.out.println(future.get());

    }


    @Test
    public void test130(){
        CompletableFuture<String> future = new CompletableFuture<>();
        new Thread(()->{
            try {
                future.get();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }


    @Test
    public void test1() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.submit(new Callable<Object>() {

            @Override
            public Object call() throws Exception {
                System.out.println("executorService 是否为守护线程" + Thread.currentThread().isDaemon());
                return null;
            }
        });

        final CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println("this is lambda supplerAdync");
            System.out.println("CompletableFuture 是否为守护线程" + Thread.currentThread().isDaemon());
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("this lambda is executed by forkJoinPool");
            return "result1";
        });

    }


    @Test
    public void test2() throws ExecutionException, InterruptedException {
        //其中: runAsync 都是没有返回值的, supplyAsync 都是有返回值的
        //public static CompletableFuture<Void> runAsync(Runnable runnable)
        //public static CompletableFuture<Void> runAsync(Runnable runnable, Executor executor)
        //public static <U> CompletableFuture<U> supplyAsync(Supplier<U> supplier)
        //public static <U> CompletableFuture<U> supplyAsync(Supplier<U> supplier, Executor executor)
        //无返回值的。
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("run end...");
        });
        future.get();

        System.out.println("=========================");
        //有返回值的call
        CompletableFuture<Long> future1 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("run end.......");
            return System.currentTimeMillis();
        });
        Long aVoid = future1.get();

        System.out.println(aVoid);
    }


    @Test
    public void test4() throws Exception {
        //当CompletableFuture 的计算结果完成,或者跑出异常时候,可以执行特定的action,
        //public CompletableFuture<T> whenComplete(BiConsumer<? super T,? super Throwable> action)
        //public CompletableFuture<T> whenCompleteAsync(BiConsumer<? super T,? super Throwable> action)
        //public CompletableFuture<T> whenCompleteAsync(BiConsumer<? super T,? super Throwable> action, Executor executor)
        //public CompletableFuture<T> exceptionally(Function<Throwable,? extends T> fn)
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (new Random().nextInt() % 2 == 0) {
                int i = 12 / 0;
            }
            System.out.println("run end....");
        });

        future.whenComplete(new BiConsumer<Void, Throwable>() {
            @Override
            public void accept(Void aVoid, Throwable throwable) {
                System.out.println("执行完成....");
            }
        });

        future.exceptionally(new Function<Throwable, Void>() {
            @Override
            public Void apply(Throwable throwable) {
                System.out.println("执行失败....");
                return null;
            }
        });

        TimeUnit.SECONDS.sleep(2);


    }


    @Test
    public void test6() {
        //线程串行化 T: 上一个任务返回的结果类型, U : 当前任务的返回值类型
        //public <U> CompletableFuture<U> thenApply(Function<? super T,? extends U> fn)
        //public <U> CompletableFuture<U> thenApplyAsync(Function<? super T,? extends U> fn)
        //public <U> CompletableFuture<U> thenApplyAsync(Function<? super T,? extends U> fn, Executor executor)
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(new Supplier<Integer>() {
            @Override
            public Integer get() {
                int nextInt = new Random().nextInt(100);
                System.out.println("result1= " + nextInt);

                return nextInt;
            }
        }).thenApply(new Function<Integer, Integer>() {
            @SneakyThrows
            @Override
            public Integer apply(Integer integer) {
                TimeUnit.SECONDS.sleep(2);
                System.out.println("result2 " + integer + 1);
                int a = 1 / 0;
                return null;
            }
        }).thenApply(new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer integer) {
                System.out.println("result3");
                return null;
            }
        });
        //    result2 依赖 result1 的结果
        //    result3 依赖 result2 的结果
        //    如果中间有线程执行出错, 先面对then 就不会执行.
    }


    @Test
    public void test12() {
        //handle 是执行任务完成时对结果的处理.
        //thenApply 和 handle 类似,
        // 但是: handle 是任务执行完之后执行, 还可以处理异常业务,
        //      thenApply 是串行化的, 有错误之后后面就不执行了.

        //public <U> CompletionStage<U> handle(BiFunction<? super T, Throwable, ? extends U> fn);
        //public <U> CompletionStage<U> handleAsync(BiFunction<? super T, Throwable, ? extends U> fn);
        //public <U> CompletionStage<U> handleAsync(BiFunction<? super T, Throwable, ? extends U> fn,Executor executor);

        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(new Supplier<Integer>() {
            @Override
            public Integer get() {
                System.out.println("start....");
                int a = 1 / 0;
                System.out.println("end....");
                return new Random().nextInt(10);
            }
        }).handle(new BiFunction<Integer, Throwable, Integer>() {
            @Override
            public Integer apply(Integer integer, Throwable throwable) {
                System.out.println("handle.....");
                return null;
            }
        }).thenApply(new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer integer) {
                System.out.println("apply.....");
                return null;
            }
        });

        //start....
        //handle.....
        //apply.....
        //    挺好玩的一个现象....
        //    总结: 在第一个出现错误之后,改方法之内, 错误代码之后的不会执行了,
        //    但是 下面的handle 方法还是会执行的, 下面的thenApply也是会执行的.

    }


    @Test
    public void test13() throws ExecutionException, InterruptedException {
        //thenAccept 都是没有返回值的,消费处理,该方法之后执行消费, 没有其他的操作.
        //public CompletionStage<Void> thenAccept(Consumer<? super T> action);
        //public CompletionStage<Void> thenAcceptAsync(Consumer<? super T> action);
        //public CompletionStage<Void> thenAcceptAsync(Consumer<? super T> action,Executor executor);
        CompletableFuture<Void> future = CompletableFuture.supplyAsync(new Supplier<Integer>() {
            @Override
            public Integer get() {
                return new Random().nextInt(10);
            }
        }).thenAccept(integer -> System.out.println(integer));
        future.get();
    }


    @Test
    public void test15() {
        //thenRun 这个方法不关心任务的处理结果,只要上面的任务完成, 就开始执行
        //public CompletionStage<Void> thenRun(Runnable action);
        //public CompletionStage<Void> thenRunAsync(Runnable action);
        //public CompletionStage<Void> thenRunAsync(Runnable action,Executor executor);
        CompletableFuture<Void> future = CompletableFuture.supplyAsync(new Supplier<Integer>() {
            @Override
            public Integer get() {
                return new Random().nextInt(10);
            }
        }).thenRun(() -> {
            System.out.println(" then run....");
        });

    }


    @Test
    public void test16() throws ExecutionException, InterruptedException {
        //thenCombine  任务合并,  thenCombine  会把两个Complentstage 的任务都执行完成之后, 把任务的结果一块交给thenCombine 来就行处理.
        //public <U,V> CompletionStage<V> thenCombine(CompletionStage<? extends U> other,BiFunction<? super T,? super U,? extends V> fn);
        //public <U,V> CompletionStage<V> thenCombineAsync(CompletionStage<? extends U> other,BiFunction<? super T,? super U,? extends V> fn);
        //public <U,V> CompletionStage<V> thenCombineAsync(CompletionStage<? extends U> other,BiFunction<? super T,? super U,? extends V> fn,Executor executor);
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                return "Hello !";
            }
        });
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                return "hello 2";
            }
        });
        CompletableFuture<String> result = future1.thenCombine(future2, new BiFunction<String, String, String>() {
            @Override
            public String apply(String s, String s2) {
                return s + "  = " + s2;
            }
        });
        System.out.println(result.get());

    }

    @Test
    public void test17() throws ExecutionException, InterruptedException {

        //当两个CompletionStage都执行完成后，把结果一块交给thenAcceptBoth来进行消耗
        //public <U> CompletionStage<Void> thenAcceptBoth(CompletionStage<? extends U> other,BiConsumer<? super T, ? super U> action);
        //public <U> CompletionStage<Void> thenAcceptBothAsync(CompletionStage<? extends U> other,BiConsumer<? super T, ? super U> action);
        //public <U> CompletionStage<Void> thenAcceptBothAsync(CompletionStage<? extends U> other,BiConsumer<? super T, ? super U> action,     Executor executor);

        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(new Supplier<Integer>() {
            @Override
            public Integer get() {
                int nextInt = new Random().nextInt(3);
                try {
                    TimeUnit.SECONDS.sleep(nextInt);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("future1:  = " + nextInt);
                return nextInt;
            }
        });

        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(new Supplier<Integer>() {
            @SneakyThrows
            @Override
            public Integer get() {
                int nextInt = new Random().nextInt(10);
                TimeUnit.SECONDS.sleep(nextInt);
                System.out.println("future2: " + nextInt);
                return nextInt;
            }
        });

        CompletableFuture<Void> future = future1.thenAcceptBoth(future2, new BiConsumer<Integer, Integer>() {
            @Override
            public void accept(Integer integer, Integer integer2) {
                System.out.println("future1= " + integer + "  future2= " + integer2);
            }
        });
        future.get();
    }


    @Test
    public void test18() throws ExecutionException, InterruptedException {
        //    applyToEither 哪个跑的快, 我就用那个结果.
        //    不管哪个方法先执行完成, 先执行完成的我就使用哪一个结果.
        //public <U> CompletionStage<U> applyToEither(CompletionStage<? extends T> other,Function<? super T, U> fn);
        //public <U> CompletionStage<U> applyToEitherAsync(CompletionStage<? extends T> other,Function<? super T, U> fn);
        //public <U> CompletionStage<U> applyToEitherAsync(CompletionStage<? extends T> other,Function<? super T, U> fn,Executor executor);
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(new Supplier<String>() {
            @SneakyThrows
            @Override
            public String get() {
                TimeUnit.SECONDS.sleep(1);
                return "future1";
            }
        });
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(new Supplier<String>() {
            @SneakyThrows
            @Override
            public String get() {
                TimeUnit.SECONDS.sleep(3);
                return "future2";
            }
        });
        CompletableFuture<Object> objectCompletableFuture = future1.applyToEither(future2, new Function<String, Object>() {
            @Override
            public Object apply(String s) {
                System.out.println(s);
                return s;
            }
        });
        System.out.println(objectCompletableFuture.get());
    }


    @Test
    public void test19() throws ExecutionException, InterruptedException {
        // 这种的acceptEither 也是哪个先执行完, 就先用哪个结果, 但是有可能两个都一样的情况,
        //CompletionStage 消耗操作.
        //public CompletionStage<Void> acceptEither(CompletionStage<? extends T> other,Consumer<? super T> action);
        //public CompletionStage<Void> acceptEitherAsync(CompletionStage<? extends T> other,Consumer<? super T> action);
        //public CompletionStage<Void> acceptEitherAsync(CompletionStage<? extends T> other,Consumer<? super T> action,Executor executor);
        CompletableFuture<Integer> f1 = CompletableFuture.supplyAsync(new Supplier<Integer>() {
            @Override
            public Integer get() {
                int t = new Random().nextInt(3);
                try {
                    TimeUnit.SECONDS.sleep(t);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("f1=" + t);
                return t;
            }
        });

        CompletableFuture<Integer> f2 = CompletableFuture.supplyAsync(new Supplier<Integer>() {
            @Override
            public Integer get() {
                int t = new Random().nextInt(3);
                try {
                    TimeUnit.SECONDS.sleep(t);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("f2=" + t);
                return t;
            }
        });
        CompletableFuture<Void> future = f1.acceptEither(f2, new Consumer<Integer>() {
            @Override
            public void accept(Integer t) {
                System.out.println(t);
            }
        });
        future.get();
    }


    @Test
    public void test20() throws ExecutionException, InterruptedException {
        //    runAfterEither : 如果有一个执行完成, 就可以执行下一步的操作, 并且 另一个没执行完成的可能会中断.
        //
        //public CompletionStage<Void> runAfterEither(CompletionStage<?> other,Runnable action);
        //public CompletionStage<Void> runAfterEitherAsync(CompletionStage<?> other,Runnable action);
        //public CompletionStage<Void> runAfterEitherAsync(CompletionStage<?> other,Runnable action,Executor executor);
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(new Supplier<String>() {
            @SneakyThrows
            @Override
            public String get() {
                TimeUnit.SECONDS.sleep(1);
                System.out.println("future1");
                return "future1";
            }
        });
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(new Supplier<String>() {
            @SneakyThrows
            @Override
            public String get() {
                TimeUnit.SECONDS.sleep(4);
                System.out.println("future2");
                return "future1";
            }
        });
        CompletableFuture<Void> future = future1.runAfterEither(future2, new Runnable() {
            @Override
            public void run() {
                System.out.println("上面已经有一个执行完成了!..........");
            }
        });
        future.get();


    }


    @Test
    public void test21() throws ExecutionException, InterruptedException {
        //runAfterBoth 需要两个都需要执行完毕之后在执行下一步的操作.

        //public CompletableFuture<Void> runAfterBoth(CompletionStage<?> other, Runnable action)
        //public CompletableFuture<Void> runAfterBothAsync(CompletionStage<?> other,Runnable action)
        //public CompletableFuture<Void> runAfterBothAsync(CompletionStage<?> other,Runnable action, Executor executor)
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(new Supplier<String>() {
            @SneakyThrows
            @Override
            public String get() {
                TimeUnit.SECONDS.sleep(3);
                System.out.println("future2......");
                return "future2";
            }
        });
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(new Supplier<String>() {
            @SneakyThrows
            @Override
            public String get() {
                TimeUnit.SECONDS.sleep(1);
                System.out.println("future1......");
                return "future1";
            }
        });

        CompletableFuture<Void> future = future1.runAfterBoth(future2, new Runnable() {
            @Override
            public void run() {
                System.out.println("两个都执行完毕了.........");
            }
        });
        future.get();
    }








    @Test
    public void test22() throws ExecutionException, InterruptedException {
        //thenCompose 允许对两个CompletionStage  进行操作,第一个操作完成时候, 将结果作为参数传递个第二个操作.
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(new Supplier<Integer>() {
            @Override
            public Integer get() {
                int nextInt = new Random().nextInt(3);
                System.out.println("future: " + nextInt);
                return nextInt;
            }
        }).thenCompose(new Function<Integer, CompletionStage<Integer>>() {
            @Override
            public CompletionStage<Integer> apply(Integer integer) {
                return CompletableFuture.supplyAsync(new Supplier<Integer>() {
                    @Override
                    public Integer get() {
                        int t = integer*2;
                        System.out.println(" t: " + t);
                        return t;
                    }
                });
            }
        });
        System.out.println(future.get());
    }




    @Test
    public void test10() throws IOException {
        CompletableFuture<Integer> f = new CompletableFuture<Integer>();

        new Thread(() -> {
            // 子线程A启动
            System.out.println("子线程A启动");
            try {
                System.out.println("子线程A沉睡5s");
                Thread.sleep(5000l);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("子线程A令future完成");
            //但是main 会直接先执行完毕.
            f.complete(100);  // 当子线程A执行到f.complete的时候，会去看是否有注册好的f的then或者when（非async的），如果有的话，会顺次去执行。 如果是async会并发执行.
            System.out.println("子线程A结束");
        }).start();

        f.whenComplete((i, ex) -> {
            // 这个场景下，whenComplete的回调的执行线程会是子线程A
            System.out.println("do something after complete begin");
            try {
                System.out.println("沉睡10s");
                Thread.sleep(10000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("do something after complete end");
        });


        System.out.println("main over");
        System.in.read();


    }

    @Test
    public void test24(){
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(8);
    }


    @Test
    public void test188() throws InterruptedException {
        String string = "12344";
        byte[] bytes = string.getBytes();
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        CountDownLatch countDownLatch = new CountDownLatch(bytes.length);
        for (byte aByte : bytes) {
            executorService.execute(()->{
                try {
                    System.out.println(aByte);
                } catch (Exception e) {

                }finally {
                    countDownLatch.countDown();
                }
            });
        }
        countDownLatch.await();


        System.out.println("================================");




    }


    private  FileUploadDO doUploadFile(String fileId, String mathml) {
        FileUploadDO fileUploadDO = new FileUploadDO();
        try {
            String imageUrl = "http:12321";
            String img = "12";
            fileUploadDO.setFileId(fileId);
            fileUploadDO.setImg(img);
            return fileUploadDO;
        } catch (Exception e) {
        }
        return fileUploadDO;
    }


    private class FileUploadDO {
        private String fileId;
        private String img;



        public String getFileId() {
            return fileId;
        }

        public void setFileId(String fileId) {
            this.fileId = fileId;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }
    }


    @Test
    public void test177(){
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        List<String> list = new ArrayList<>(16);
        List<CompletableFuture<FileUploadDO>> futureList = list
                .stream()
                .map(dto -> CompletableFuture.supplyAsync(() -> doUploadFile("1", "2"), executorService))
                .collect(Collectors.toList());

        CompletableFuture<Void> future = CompletableFuture.allOf(futureList.toArray(new CompletableFuture[0]));
        future.join();

        Map<String, String> map = new HashMap<String,String>();
        try {
            map = futureList.stream().map(y -> {
                try {
                    return y.get();
                } catch ( Exception e) {
                    System.err.println("replaceQuestionMark method");
                }
                return new FileUploadDO();
            }).collect(Collectors.toMap(FileUploadDO::getFileId, FileUploadDO::getImg, (k1, k2) -> k1));
            System.err.println("replaceQuestionMark check taskId:{},map:{}");
        } catch ( Exception e) {
            System.err.println("map method");
        }

        ForkJoinPool forkJoinPool = new ForkJoinPool();

    }

}
