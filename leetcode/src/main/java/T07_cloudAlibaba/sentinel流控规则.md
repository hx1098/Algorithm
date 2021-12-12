[TOC]

## 1.流控规则基本介绍

![image-20211211142807725](https://cdn.jsdelivr.net/gh/hx1098/Algorithm@master/img/nacos/20211211142807.png)

#### 名词解释

- 资源名：唯一名称，默认请求路径
- 针对来源：Sentinel可以针对调用者进行限流，填写微服务名，默认default（不区分来源）
- 阈值类型/单机阈值：
  - QPS（每秒钟的请求数量）：当调用该API的QPS达到阈值的时候，进行限流
  - 线程数：当调用该API的线程数量达到阈值的时候，进行限流
- 是否集群：当前不需要集群
- 流控模式：
  - 直接：API达到限流条件时，直接限流
  - 关联：当关联的资源达到阈值时，就限流自己
  - 链路：只记录指定链路上的流量（指定资源从入口资源进来的流量，如果达到阈值，就进行限流）(API级别的针对来源)
- 流控效果：
  - 快速失败：直接失败，抛异常
  - Wam Up：根据codeFactor（冷加载因子，默认3）的值，从阈值/codeFacotor，经过预热时长，才达到设置的QPS阈值
  - 排队等待：匀速排队，让请求以匀速的速度通过，阈值类型必须设置为QPS，否则无效



## 2.QPS直接失败案例

1.qps可以从簇点链路中添加, 也可以从流控规则汇总添加, 1秒只能访问一次,超过就报错

![image-20211211143201312](https://cdn.jsdelivr.net/gh/hx1098/Algorithm@master/img/nacos/20211211143201.png)

手速过快时候就有sentinel的限制的提示了.

![image-20211211143236246](https://cdn.jsdelivr.net/gh/hx1098/Algorithm@master/img/nacos/20211211143236.png)

## 3,线程数失败案例

开启来个testA, 每个模拟代码执行是时间, 先让他睡上个1秒钟, 可以看到两个同时请求的时候, 就会直接报错了, 太简单, 不过多演示了, 但是这里和上面的有责本质的区别, 一个是以线程来控制的, 一个是以qps来控制的. 

![image-20211211143753241](https://cdn.jsdelivr.net/gh/hx1098/Algorithm@master/img/nacos/20211211143753.png)



## 4.流控规则--关联

关联的含义: 商品支付服务A, 订单系统B,  当支付服务A在承载不了太多的压力的时候, 就去直接限制下单服务B, 很简单的一个道理, 就像孩子学习成绩不好, 老师去找找家长一样, 就是这个意思.

```java
@RestController
public class DemoController {

    @GetMapping("/testA")
    @SentinelResource(value = "testA")
    public String testA() throws InterruptedException {

      /*  TimeUnit.SECONDS.sleep(1);*/

        System.out.println("=====testA=====");
        return "===testA====";
    }

    @GetMapping("/testB")
    @SentinelResource(value = "testB")
    public String testB() {
        System.out.println("=====testB=====");
        return "===testB====";
    }

}
```

如何添加:

![image-20211211145829034](https://cdn.jsdelivr.net/gh/hx1098/Algorithm@master/img/nacos/20211211145829.png)

使用postmam并发访问B接口,然后再用浏览器去请求A接口, 此时A接口限制访问. 

![image-20211211155438970](https://cdn.jsdelivr.net/gh/hx1098/Algorithm@master/img/nacos/20211211155439.png)





![image-20211211155528119](https://cdn.jsdelivr.net/gh/hx1098/Algorithm@master/img/nacos/20211211155528.png)

## 5.流控规则--链路

可以理解为两个两个test接口A,和B, 同时访问C,  但是我只想限制A的入口, 这种情况下就可以进行使用链路的方式来实现, 这个就好比养生馆一样, 其目的都是养生, 有些男生女生都可以进去, 有些就只能女生进, 男生止步(虽然我也没有进去过)

```java

    @GetMapping("/testA")
    @SentinelResource(value = "testA")
    public String testA() throws InterruptedException {
        System.out.println("testA");
        return testService.common();
    }

    @GetMapping("/testB")
    @SentinelResource(value = "testB")
    public String testB() {
        System.out.println("testB");
        return testService.common();
    }
```

```java
@Service
public class TestService {

    @SentinelResource("common")
    public String common() {
        return "common";
    }
}
```

从1.6.3 版本开始，Sentinel Web filter默认收敛所有URL的入口context，因此链路限流不生效。

 1.7.0 版本开始（对应SCA的2.1.1.RELEASE)，官方在CommonFilter 引入了WEB_CONTEXT_UNIFY 参数，用于控制是否收敛context。将其配置为 false 即可根据不同的URL 进行链路限流。SCA 2.1.1.RELEASE之后的版本,可以通过配置spring.cloud.sentinel.web-context-unify=false即可关闭收敛
————————————————

```yaml
sentinel:
  transport:
    # 配置Sentinel dashboard地址
    dashboard: localhost:8080
    # 默认8719端口，键入被占用会自动从8719+1，直到找到未被占用的端口
    port: 8719
  web-context-unify: false
```

![image-20211211161926594](https://cdn.jsdelivr.net/gh/hx1098/Algorithm@master/img/nacos/20211211161926.png)



## 6.流控效果

### 1.预热

​		https://sentinelguard.io/zh-cn/docs/flow-control.html

​        冷启动（`RuleConstant.CONTROL_BEHAVIOR_WARM_UP`）方式。该方式主要用于系统长期处于低水位的情况下，当流量突然增加时，直接把系统拉升到高水位可能瞬间把系统压垮。通过"冷启动"，让通过的流量缓慢增加，在一定时间内逐渐增加到阈值上限，给冷系统一个预热的时间，避免冷系统被压垮的情况。具体的例子参见 [WarmUpFlowDemo](https://github.com/alibaba/Sentinel/blob/master/sentinel-demo/sentinel-demo-basic/src/main/java/com/alibaba/csp/sentinel/demo/flow/WarmUpFlowDemo.java)。

主要应用在一些秒杀的系统, 流量暴增的情况, 避免吧系统直接拉胯, 而是有一个曲线的过程.

![image-20211211165200911](https://cdn.jsdelivr.net/gh/hx1098/Algorithm@master/img/nacos/20211211165200.png)

![image-20211211171603794](https://cdn.jsdelivr.net/gh/hx1098/Algorithm@master/img/nacos/20211211171603.png)





### 2.排序等待/匀速器

1. 匀速器（`RuleConstant.CONTROL_BEHAVIOR_RATE_LIMITER`）方式。这种方式严格控制了请求通过的间隔时间，也即是让请求以均匀的速度通过，对应的是漏桶算法。具体的例子参见 [PaceFlowDemo](https://github.com/alibaba/Sentinel/blob/master/sentinel-demo/sentinel-demo-basic/src/main/java/com/alibaba/csp/sentinel/demo/flow/PaceFlowDemo.java)。



