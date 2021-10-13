

### 1.什么是垃圾对象?

#### 1.引用计数法: 

使用引用计数法的会产生循环引用的情况, 但是理论上应该被回收的, 但是有没有对象可以对他进行调用., 引用计数法默认引用还是大于0 的,不会被回收.

#### 2.根可达算法

gcroots 定义的 局部变量, 静态变量, 常量, jni指针 这些是根

然后从这写变量中间找可达性关系. 如图中所示的: 其中箭号可达的就是不能回收的, 他就是一种链路关系图

java中JVM使用的就是根可达算法

<img src="https://cdn.jsdelivr.net/gh/hx1098/Algorithm@master/img/jvm/20211010101546.png" alt="image-20211010091909749" style="zoom:80%;" />



### 2.垃圾回收算法

#### 1.标记清除

会产生内存碎片, 造成不连续的现象, 大对象无法进行分配(java中分配大对象需要占据连续的内存空间)

#### 2.标记压缩



#### 3.复制算法

复制就需要开辟两个一模一样的大小的空间, 将标记的东西整理到另一个区域, 剩下的就滚吧.

<img src="https://cdn.jsdelivr.net/gh/hx1098/Algorithm@master/img/jvm/20211010101824.png" alt="image-20211010101823999" style="zoom:80%;" />



### 3.垃圾回收模型

#### 1.分代模型

前面六个是数据分代模型

#### 2.分区模型

后面四个属于分区模型

<img src="https://cdn.jsdelivr.net/gh/hx1098/Algorithm@master/img/jvm/20211010214635.png" alt="image-20211010214635624" style="zoom:80%;" />



分代模型与分区模型

分代模型: 新生代:复制算法，老年代：标记整理，标记清除算法

<img src="https://cdn.jsdelivr.net/gh/hx1098/Algorithm@master/img/jvm/20211010214939.png" alt="image-20211010214938921" style="zoom:80%;" />







### 4.垃圾回收

#### 1.serial serial old

这些是单线程垃圾回收器, 所以一旦老年代满了的话, 业务线程就会产生停顿(STW), 

<img src="https://cdn.jsdelivr.net/gh/hx1098/Algorithm@master/img/jvm/20211012065327.png" alt="image-20211012065320597" style="zoom:80%;" />





#### 2.PS垃圾回收器(吞吐量优先)

​	举个栗子, 单线程的垃圾回收器好比你是一个人住, 买了个小房子(前提是你得有钱, 不过租的也行, 没毛病), 自己一个人打扫, 然后慢慢的有有了女朋友, 有了孩子, 把父母也接过来住了, 这个时候不够住了呀, 房子太小了多尴尬呀, 就直接换了一个大的房子住, 但是你自己清扫的时候就清扫不过来了呀, 你就呼朋唤友, 叫上你的家人一起清理, 这就是并发清理了.

​	但是可以看到, 业务线程和GC线程任然是不在一起执行的, 只是会减少STW的时间,原来10秒, 现在可能变秒nan了, 反正就是快嘛, 但是也会有缺点,  你需要跟你的服务器cpu相匹配才行, 不然线程开的太多, 增加了cpu的上下文切换也是会变慢的.

​	所以并发并不能解决STW的时间.



<img src="https://cdn.jsdelivr.net/gh/hx1098/Algorithm@master/img/jvm/20211012065507.png" alt="image-20211012065507302" style="zoom:80%;" />







#### 3.CMS(Concurrent Mark Sweep)

​	并发标记清理垃圾, 一般来说CMS(回收老年代)和ParNew(新生代并发)组合使用,  但是通过下面的例子可以看到, 这家伙也是没有解决STW的停顿现象(貌似还没有垃圾回收器能做到吧, 多多少少都有停顿时间),  在初始标记阶段和重新标记阶段, 他还是会自己玩的, 只是一定程度上减少了STW的这种现象.

​	有小伙伴问了, 问啥需要重新标记呢? 因为前面已经有业务线程和GC线程在跑了, 后面清理的难点在于: 再初始标记之后你不知道又产生了多少个垃圾, 产生了多少个引用的变化, 这些引用还有没有用, 需不需要进行回收. 这就好比你家狗子就是那个业务线程, 早上你把家里收拾的好好的, 整整齐齐, 干干净净的, 但是你下班之后你不知道你还能不能认得出来是不是你家一样, 狗子在家可能还是会产生立即, 有可能是沙发掏了个洞, 也有可能是卫生纸碎片铺满了一地, 这都是垃圾的不确定性.

​	

<img src="https://cdn.jsdelivr.net/gh/hx1098/Algorithm@master/img/jvm/20211011225545.png" alt="image-20211011225538755" style="zoom:80%;" />



所以为了实现并发的垃圾回收, 这里采用的是三色标记(Tri-color marking),

三色标记的解释: 



https://blog.csdn.net/u013490280/article/details/107495053

https://en.wikipedia.org/wiki/Tracing_garbage_collection#TRI-COLOR

感谢这位老哥的维基百科出来的好东西.





<img src="https://cdn.jsdelivr.net/gh/hx1098/Algorithm@master/img/jvm/20211012072517.png" alt="image-20211012072517328" style="zoom:80%;" />
