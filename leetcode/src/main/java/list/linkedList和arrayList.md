[TOC]

#### arrayList

```
基于动态数组,连续内存空间存储,适合下标访问, 随机访问, 因为数组的长度固定,超出长度时候哦需要新建数组,然后将老数组拷贝到新数组中去,如果不是尾部插入数据的话,还会涉及到元素的移动,使用尾插法并制定初始容量可以提升性能,设置超过linklist.
```

#### 

#### linkedList

```
基于链表,可以存储在分散的内存中去,适合做删除和删除的操作,不适合查询,需要遍历,
遍历LinkedList必须使用iterator不能不能使用for循环,因为每次for循环体内通过get(i)取得某一元素时候需要对list进行重新遍历,性能消耗极大
另外,不要试图使用indexOf等返回元素索引,并利用其进行遍历,使用indesOf进行遍历时候, 当结果为空的时候,会遍历整个列表.
```

#### 双亲委派模型

```
BootstrapClassLoader, ExtClassLoader, AppClassLoader.

保证安全性, 不会重复加载
```



#### java异常体系

```
ThrowTable, 在java体系中顶级父类, 他有两个子类: Error和Exception
Error 程序无法处理
Exception 程序可以处理, 又包含: RuntimeException(运行) 和 CheckedExecption(编译期间)
RuntimeException 
```





GC如何判断对象是可以被回收的

```

```

