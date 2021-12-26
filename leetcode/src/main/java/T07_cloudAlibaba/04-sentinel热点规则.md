[TOC]

## 1.热点规则

https://sentinelguard.io/zh-cn/docs/parameter-flow-control.html

什么是热点数据? 热点就是经常访问的数据,很多时候我们希望统计某个热点数据中访问频次最高的 Top K 数据，并对其访问进行限制。

比如：

- 商品 ID 为参数，统计一段时间内最常购买的商品 ID 并进行限制
- 用户 ID 为参数，针对一段时间内频繁访问的用户 ID 进行限制(比如最近的王*红事件😀😀😀)

![image-20211225141443311](https://cdn.jsdelivr.net/gh/hx1098/Algorithm@master/img/nacos/20211225141531.png)

废话不多说直接贴代码:

```java
 @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey",blockHandler = "handlerHotKey",fallback = "testHotKeyThrowError")
    public String testHotData(@RequestParam(value = "hot1",required = false)String hot1,
                              @RequestParam(value = "hot2",required = false)String hot2,
                              @RequestParam(value = "hot3",required = false)String hot3) {
        //System.out.println(hot1);
       /* if ("wangLiHong".equalsIgnoreCase(hot1)) {
            throw new RuntimeException("某某某明星又上头条了， 这瓜包熟哇!!!");
        }*/
        /*int cc = 1 / 0;*/
        return "testHotKey";
    }

    /**
     * 限流降级的时候跑出的错误
     * @return String
     */
    public String handlerHotKey(String hot1,String hot2, String hot3, BlockException e) {
        return "由于这家伙流量太大, 程序员小哥正在抢修中......";
    }

    /**
     * 报错有异常时候报出的错误
     * @return String
     */
    public String testHotKeyThrowError(String hot1,String hot2, String hot3,Throwable e) {
        return "这次接口是真的报错了!!!";
    }
```

1. sentinel 的简单配置:

**限流模式:**由于sentienl的限流模式仅仅支持QPS模式, 所以也只能选择QPS的模式来进行限制, 

**参数索引:**就是第几个参数可以进行限流, 默认从0开始, 基础中的基础了,

**单机阈值:**也就是最大的访问次数, 达到这个次数的时候就会进行限流了.

<img src="https://cdn.jsdelivr.net/gh/hx1098/Algorithm@master/img/nacos/20211225142518.png" alt="image-20211225142518670" style="zoom:80%;" />

![image-20211225143404469](https://cdn.jsdelivr.net/gh/hx1098/Algorithm@master/img/nacos/20211225143404.png)



2. sentinel 的进阶配置:

参数的额外项就是可以控制的更加精细, 比如我们可以设置hot1=wanglihong这个参数到达某一个10阈值时候进行限流, 参数类型仅仅支持7中数据类型, 

<img src="https://cdn.jsdelivr.net/gh/hx1098/Algorithm@master/img/nacos/20211225143822.png" alt="image-20211225143822518" style="zoom:80%;" />



<img src="https://cdn.jsdelivr.net/gh/hx1098/Algorithm@master/img/nacos/20211225144223.png" alt="image-20211225144223153" style="zoom:80%;" />







## 2.系统规则

系统规则理解很简单, 即系统级别的规则, 只要你来我这边的请求, 都需要遵守的, 基本上就一个阈值设置好就可以了.

1. **LOAD** : （仅对 Linux/Unix-like 机器生效）：当系统 load1 超过阈值，且系统当前的并发线程数超过系统容量时才会触发系统保护。系统容量由系统的 `maxQps * minRt` 计算得出。设定参考值一般是 `CPU cores * 2.5`。
2. **RT**(**Round Trip Time响应时间**): 单台机器上所有入口流量的平均 RT 达到阈值即触发系统保护，单位是毫秒。
3. **线程数:** 当单台机器上所有入口流量的并发线程数达到阈值即触发系统保护。
4. **入口QPS**: 当单台机器上所有入口流量的 QPS 达到阈值即触发系统保护。
5. **CPU使用率**: 当系统 CPU 使用率超过阈值即触发系统保护（取值范围 0.0-1.0）

![image-20211223170538205](https://cdn.jsdelivr.net/gh/hx1098/Algorithm@master/img/nacos/20211223170545.png)    

