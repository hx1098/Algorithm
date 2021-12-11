[TOC]

## 1.Sentinel初始化

1.启动nacos,

2.启动sentinel   java -jar sentinel.jar

3.启动sentinel服务

sentinel官方文档手册:

https://sentinelguard.io/zh-cn/docs/quick-start.html



创建服务, 导入依赖:

```xml
<!-- Nacos客户端依赖 -->
<dependency>
    <groupId>com.alibaba.cloud</groupId>
    <artifactId>spring-cloud-starter-alibaba-nacos-discovery</artifactId>
</dependency>
<!-- sentinel依赖 -->
<dependency>
    <groupId>com.alibaba.csp</groupId>
    <artifactId>sentinel-core</artifactId>
</dependency>
```

配置yaml文件:

```xml
server:
  port: 8401

spring:
  application:
    name: cloudalibaba-sentinel-service
  cloud:
    nacos:
      discovery:
        server-addr: localhost:8848
    sentinel:
      transport:
        # 配置Sentinel dashboard地址
        dashboard: localhost:8080
        # 默认8719端口，键入被占用会自动从8719+1，直到找到未被占用的端口
        port: 8719

management:
  endpoints:
    web:
      exposure:
        include: '*'
```

编写controller:

```java
@RestController
public class FlowLimitController {
    @GetMapping("/testA")
    public String testA(){
        return "-----testA";
    }
}
```

以上启动完成后, 在浏览器输入sentinel地址即可:

![image-20211211141854247](https://cdn.jsdelivr.net/gh/hx1098/Algorithm@master/img/nacos/20211211141901.png)

