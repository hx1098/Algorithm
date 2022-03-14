package juc;


import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.*;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2022/1/13 14:24
 * @description
 * @editUser hx
 * @editTime 2022/1/13 14:24
 * @editDescription 这个future是多线程批量添加数据
 */
public class testThreadImport {

    //@Transactional(rollbackFor = Exception.class)
  /*  public int addFreshStudentsNew(List<FreshStudentAndStudentModel> list, String schoolNo) {
        if (list == null || list.isEmpty()) {
            return 0;
        }
        *//*List<StudentEntity> studentEntityList = new LinkedList<>();
        List<EnrollStudentEntity> enrollStudentEntityList = new LinkedList<>();
        List<AllusersEntity> allusersEntityList = new LinkedList<>();

        list.forEach(freshStudentAndStudentModel -> {
            EnrollStudentEntity enrollStudentEntity = new EnrollStudentEntity();
            StudentEntity studentEntity = new StudentEntity();
            BeanUtil.copyProperties(freshStudentAndStudentModel, studentEntity);
            BeanUtil.copyProperties(freshStudentAndStudentModel, studentEntity);
            BeanUtil.copyProperties(freshStudentAndStudentModel, enrollStudentEntity);
            String operator = UUID.randomUUID().toString();
            String studentId = UUID.randomUUID().toString();
            enrollStudentEntity.setId(UUID.randomUUID().toString());
            enrollStudentEntity.setStudentId(studentId);
            enrollStudentEntity.(setIdentityCardIdfreshStudentAndStudentModel.getIdCard());
            enrollStudentEntity.setOperator(operator);
            studentEntity.setId(studentId);
            studentEntity.setIdentityCardId(freshStudentAndStudentModel.getIdCard());
            studentEntity.setOperator(operator);
            studentEntityList.add(studentEntity);
            enrollStudentEntityList.add(enrollStudentEntity);

            AllusersEntity allusersEntity = new AllusersEntity();
            allusersEntity.setId(enrollStudentEntity.getId());
            allusersEntity.setUserCode(enrollStudentEntity.getNemtCode());
            allusersEntity.setUserName(enrollStudentEntity.getName());
            allusersEntity.setSchoolNo(schoolNo);
            allusersEntity.setTelNum(enrollStudentEntity.getTelNum());
            allusersEntity.setPassword(enrollStudentEntity.getNemtCode());  //密码设置为考生号
            allusersEntityList.add(allusersEntity);
        });*//*


        int nThreads = 50;

        int size = enrollStudentEntityList.size();
        ExecutorService executorService = Executors.newFixedThreadPool(nThreads);
        List<Future<Integer>> futures = new ArrayList<Future<Integer>>(nThreads);

        //size = 160
        //第一轮: start: 160/50*0 = 0 , end: 160/50*(0+1)=

        for (int i = 0; i < nThreads; i++) {
            final List<EnrollStudentEntity> EnrollStudentEntityImputList = enrollStudentEntityList.subList(size / nThreads * i, size / nThreads * (i + 1));
            final List<StudentEntity> studentEntityImportList = studentEntityList.subList(size / nThreads * i, size / nThreads * (i + 1));
            final List<AllusersEntity> allusersEntityImportList = allusersEntityList.subList(size / nThreads * i, size / nThreads * (i + 1));

            Callable<Integer> task1 = () -> {
                studentSave.saveStudent(EnrollStudentEntityImputList,studentEntityImportList,allusersEntityImportList);
                return 1;
            };
            futures.add(executorService.submit(task1));
        }
        executorService.shutdown();
        if (!futures.isEmpty() && futures != null) {
            return 10;
        }
        return -10;
    }
*/
    //测试100次
    // 2 个:    6
    // 4 个:    6
    // 8 个：   7
    // 16 个：  7
    // 24 个：  7
    // 50 个：  9
    // 100 个：  14

    public static void main(String[] args) {
        //List<Integer> times = new ArrayList<>();
        //for (int j = 0; j < 100; j++) {
        long start = System.currentTimeMillis();
        List<String> enrollStudentEntityList = new ArrayList<>();
        for (int i = 0; i < 190; i++) {
            enrollStudentEntityList.add(UUID.randomUUID().toString());
        }

        int nThreads = 30;
        int size = 190;
        ExecutorService executorService = Executors.newFixedThreadPool(nThreads);
        List<Future<Integer>> futures = new ArrayList<Future<Integer>>(nThreads);
        //定义一个任务集合
        List<String> integers = null;
        for (int i = 0; i < nThreads; i++) {
            if (i ==  nThreads - 1) {
                integers = enrollStudentEntityList.subList(size / nThreads * i, size);
                System.out.println("---------------------------------------------------");
            } else {
                integers = enrollStudentEntityList.subList(size / nThreads * i, size / nThreads * (i + 1));
            }
            // 160 / 2 * 0 = 0,  160/2 * (0+1) = 80
            // 160 / 2 * 1 = 80, 160/2 * (1+1) = 160
            System.out.println("size: " + size + "  i: " + i + "  nthreads: " + nThreads + "  , (" + size / nThreads * i + " ," + size / nThreads * (i + 1) + ")");
            int finalI = i;
            Callable<Integer> task1 = () -> {
                System.out.println("第" + (finalI + 1) + "批保存的数据");
                return 1;
            };
            futures.add(executorService.submit(task1));
        }
        executorService.shutdown();


        if (!futures.isEmpty() && futures != null) {
            System.out.println("10");
        } else {
            System.out.println(-10);
        }
        Integer integer = Integer.valueOf((int) (System.currentTimeMillis() - start));
        System.out.println("耗费时间: " + integer);
        //times.add(integer);
        //}

       /* int a = 0;
        System.out.println("time.size" + times.size());
        for (int i = 0; i < times.size(); i++) {
            System.out.println(times.get(i));
            a = a + times.get(i);
        }
        System.out.print("平均值： ");
        System.out.println(a / times.size());*/
    }


    public static void main2(String[] args) throws ExecutionException, InterruptedException {
        long star = System.currentTimeMillis();
        CompletableFuture<String> startFuture = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < 1000; i++) {
                System.out.println("thread startFuture -11111111111");
            }
            return "12";
        });
        CompletableFuture<String> endFuture = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < 1000; i++) {
                System.out.println("thread startFuture -2222222222");
            }
            return "13";
        });
        CompletableFuture.allOf(startFuture, endFuture);
        String startResult = startFuture.get();
        String endResult = endFuture.get();
        System.out.println(startResult + "  " + endResult);
        System.out.println(System.currentTimeMillis() - star);


    }


    public static void main3(String[] args) throws ExecutionException, InterruptedException {
        Object o = new Object();
        long star = System.currentTimeMillis();
        synchronized (o) {
            CompletableFuture<String> startFuture = CompletableFuture.supplyAsync(() -> {
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for (int i = 0; i < 1000; i++) {
                    System.out.println("thread startFuture -11111111111");
                }
                return "12";
            });
            CompletableFuture<String> endFuture = CompletableFuture.supplyAsync(() -> {
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for (int i = 0; i < 1000; i++) {
                    System.out.println("thread startFuture -2222222222");
                }
                return "13";
            });
            CompletableFuture.allOf(startFuture, endFuture);
            String startResult = startFuture.get();
            String endResult = endFuture.get();
            System.out.println(startResult + "  " + endResult);
            System.out.println(System.currentTimeMillis() - star);
        }


    }


    @Test
    public void test1() {
        List<String> uuids = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            uuids.add(UUID.randomUUID().toString());
        }
        List<String> strings = uuids.subList(1, 101);

    }


}
