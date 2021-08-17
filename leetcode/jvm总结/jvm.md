[TOC] 



# JVM的整理

## 1.(Safepoint)安全点是什么:

- 1.从线程的角度来讲,安全点就是代码执行中的一些特殊位置,当线程执行到这些的特殊的位置,如果此时在GC,那抹在这个地方的线程会暂停,知道GCj结束.

- 2.GC的时候要挂起所有活动的线程,因此线程要挂起,会选择在到达安全点时候挂起.

- 3.安全点的这个特殊的位置保存了线程上下文所有的信息,说白了,在进入安全点的时候,打印日志就可以看到线程此刻在干啥.

  有关安全点的信息:

  摘自: https://www.jianshu.com/p/228fed39369f

  https://www.jianshu.com/p/c79c5e02ebe6

  https://blog.csdn.net/lqp276/article/details/52249438

  

## 2.STW的原因:

STW是什么:

stop the world 是指在在GC的过程中,会产生应用程序的停顿,停顿产生时整个应用线程都会被暂停,没有任何响应,有点像卡死的感觉,这个停顿被称为stw, Java中一种全局暂停的现象,全局停顿,所有Java代码停止,native代码可以执行,但不能与JVM进行交互,这些现象多半是由于GC引起.

https://blog.csdn.net/weixin_44704538/article/details/108222022?utm_medium=distribute.pc_relevant.none-task-blog-2%7Edefault%7EBlogCommendFromBaidu%7Edefault-7.base&depth_1-utm_source=distribute.pc_relevant.none-task-blog-2%7Edefault%7EBlogCommendFromBaidu%7Edefault-7.base

首先垃圾回收时要经过标记的, 对象被标记后会根据不同的区域采用不同的收集算法.

大家有没有想过一件事,当虚拟机完成两次标记之后,便确认了垃圾回收的对象. 但此时, 垃圾回收的线程和程序线程是在并行的执行的,并不会因为要回收垃圾就停掉程序线程. 那抹问题来了,当GC线程标记好一个对象的时候,我们的程序线程又将一个"将会回收" 的对象重新拉入了"关系网"中,当执行第二次标记的时候,该对象没有重写finalize()方法,因此回收的时候就会 回收 了这个不改回收的对象.

虚拟机的解决方案就是在一些特定指定的指定位置设置一些"**安全点**", 当程序运行到这些"安全点" 的时候,就会暂停所有当前运行的线程(Stop the World),简称**stw**,暂停后再找到"**GC ROOTs**",进行关系的组建,进而执行标记和清除.



## 3.STW的总结

| 序号 | 收集器      | 收集范围 | 算法               | 执行类型   |
| ---- | ----------- | -------- | ------------------ | ---------- |
| 1    | Serial      | 新生代   | 复制               | 单线程     |
| 2    | ParNew      | 新生代   | 复制               | 多线程并行 |
| 3    | Parallel    | 新生代   | 复制               | 多线程并行 |
| 4    | SerialOld   | 老年代   | 标记整理           | 单线程     |
| 5    | CMS         | 老年代   | 标记清除           | 多线程并发 |
| 6    | ParallerOld | 老年代   | 标记整理           | 多线程     |
| 7    | G1          | 全部     | 复制算法, 标记整理 | 多线程     |
| 8    |             |          |                    |            |



