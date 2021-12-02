[TOC]

## 1.官网下载

https://github.com/alibaba/nacos/releases/tag/2.0.3

## 2.启动

```bash
#linux
sh startup.sh -m standalone
#window
startup.cmd -m standalone

http://localhost:8848/nacos
```



## 3.注册:

建立个项目

```java
@SpringBootApplication
@EnableDiscoveryClient
public class Nacos9001Application {

    public static void main(String[] args) {
        SpringApplication.run(Nacos9001Application.class, args);
    }

}
```



```java
/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/11/29 14:04
 * @description
 * @editUser hx
 * @editTime 2021/11/29 14:04
 * @editDescription
 */
@RestController
public class DemoController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "test")
    public String  getServerPort() {
        return "hello nacos discovery" + serverPort;
    }
}
```

```yaml
server:
  port: 9001
spring:
  application:
    name: nacos-provider
  cloud:
    nacos:
      server-addr: 127.0.0.1:8848
management:
  endpoint:
    web:
      exposure:
        include: '*'
```

```xml
groupId>com.hx</groupId>
    <artifactId>nacos-9001</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <name>nacos-9001</name>
    <description>Demo project for Spring Boot</description>

    <parent>
        <groupId>com.hx</groupId>
        <artifactId>alibabacloud</artifactId>
        <version>0.0.1-SNAPSHOT</version>
        <relativePath/>
    </parent>

    <properties>
        <java.version>1.8</java.version>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>
    </properties>

    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>com.alibaba.cloud</groupId>
            <artifactId>spring-cloud-starter-alibaba-nacos-discovery</artifactId>
        </dependency>
    </dependencies>
```



## 4.Nacos 何时选择切换模式

	1. 一般来说，如果不需要储存服务界别的信息且服务实例通过nacos-client注册，并能够保持心跳上报，那么就可以选择AP模式。如Spring Cloud 和 Dubbo，都适用于AP模式，AP模式为了服务的可用性减弱了一致性，因此AP模式下只支持注册临时实例。
	2. 如果需要在服务级别编辑或者储存配置信息，那么CP是必须的，K8S服务和DNS服务则是用于CP模式。CP模式下则支持注册持久化实例，此时则是以Raft协议为集群运行模式，该模式下注册实例之前必须先注册服务，如果服务不存在，则会返回错误。

3. 切换命令（默认是AP）：

```java
curl -X PUT '$NACOS_SERVER:8848/nacos/v1/ns/operator/switches?entry=serverMode&value=CP'
```



注意：临时和持久化的区别主要在健康检查失败后的表现，持久化实例健康检查失败后会被标记成不健康，而临时实例会直接从列表中被删除。



## 5.自动配置更新

```xml
<dependency> 
    <groupId> com.alibaba.cloud </groupId> 
    <artifactId> spring-cloud-starter-alibaba-nacos-config </artifactId> 
</dependency>
```

ymly 需要配置两个, 因为config项目和nacos的普通项目一样, 自己先从配置中心进行拉取.

分别要配置的是，这里bootstrap.yml配置好了以后，作用是两个，第一个让3377这个服务注册到Nacos中，第二个作用就是去Nacos中去读取指定后缀为yaml的配置文件：

```yaml
# nacos配置
server:
  port: 3377

spring:
  application:
    name: nacos-config-client
  cloud:
    nacos:
      discovery:
        server-addr: localhost:8848 #Nacos服务注册中心地址
      config:
        server-addr: localhost:8848 #Nacos作为配置中心地址
        file-extension: yaml #指定yaml格式的配置
```

application.yml

```java
spring:
  profiles:
    active: dev # 表示开发环境
```

main

```java
@SpringBootApplication
@EnableDiscoveryClient
public class CloudalibabaConfig3377Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudalibabaConfig3377Application.class, args);
    }
```



controller:

```java
@RestController
@RefreshScope //支持Nacos的动态刷新功能
public class ConfigClientController {

    @Value("${config.info}")
    private String configInfo;

    @Value("${/config/info}")
    public String getConfigInfo(){
        return configInfo;
    }

}
```

去nacos进行配置:

![image-20211130071701437](https://cdn.jsdelivr.net/gh/hx1098/Algorithm@master/img/nacos/20211130071701.png)

![image-20211130071532264](https://cdn.jsdelivr.net/gh/hx1098/Algorithm@master/img/nacos/20211130071628.png)

```
config: 
    info: nacos config center,version = 1
```

```url
http://localhost:3377/config/info
```



## 6.namespace, group,dataID的关系

### dataID方案:

1.新建一个dataID

```yaml
#新建一个dataID
nacos-config-client-test.yaml

config: 
 info: nacos config center test, version = 2
```

![image-20211201202144182](https://cdn.jsdelivr.net/gh/hx1098/Algorithm@master/img/nacos/20211201202144.png)

![image-20211201203218721](https://cdn.jsdelivr.net/gh/hx1098/Algorithm@master/img/nacos/20211201203218.png)

2.修改项目的环境

![image-20211201202612653](https://cdn.jsdelivr.net/gh/hx1098/Algorithm@master/img/nacos/20211201202612.png)

3.访问: http://localhost:3377/config/info

![image-20211201202716211](https://cdn.jsdelivr.net/gh/hx1098/Algorithm@master/img/nacos/20211201202716.png)

### group方案

1.还是和上面的一样, 新建一个配置文件, 注意选择的默认分组, 

![image-20211201203136091](https://cdn.jsdelivr.net/gh/hx1098/Algorithm@master/img/nacos/20211201203136.png)

分别新建两个config

**名称**:	　nacos-config-client-info.yaml

**分组**：　DEV_GROUP

**Description**:　dev-group-cofing



**名称**:	　nacos-config-client-test.yaml

**分组**：　DEV_GROUP

**Description**:　dev-test-group

```yaml
nacos-config-client-info.yaml

config:
    info: nacos-config-client-info.yaml, dev-group
```

```yaml
nacos-config-client-test.yaml

config:
    info: nacos-config-client-test.yaml version = 1
```

![image-20211201203428389](https://cdn.jsdelivr.net/gh/hx1098/Algorithm@master/img/nacos/20211201203428.png)

点击发布后入下图所示: 

![image-20211201203654812](https://cdn.jsdelivr.net/gh/hx1098/Algorithm@master/img/nacos/20211201203654.png![image-20211201204029642](https://cdn.jsdelivr.net/gh/hx1098/Algorithm@master/img/nacos/20211201204029.png)

然后再项目中增加分组, 同时指定改分组下有的环境, 再次访问: http://localhost:3377/config/info

![image-20211201204620244](https://cdn.jsdelivr.net/gh/hx1098/Algorithm@master/img/nacos/20211201204620.png)

![image-20211201204636650](https://cdn.jsdelivr.net/gh/hx1098/Algorithm@master/img/nacos/20211201204636.png)





### namespace

#### 1.新建立一个明明空间, 

![image-20211201205147808](https://cdn.jsdelivr.net/gh/hx1098/Algorithm@master/img/nacos/20211201205147.png)

![image-20211201205645300](https://cdn.jsdelivr.net/gh/hx1098/Algorithm@master/img/nacos/20211201205645.png)

![image-20211201205416140](https://cdn.jsdelivr.net/gh/hx1098/Algorithm@master/img/nacos/20211201205416.png)

![image-20211201205520404](https://cdn.jsdelivr.net/gh/hx1098/Algorithm@master/img/nacos/20211201205520.png)

此时我们可以看到config下头部有是三个空间, 分别是public, dev, test

![image-20211201205841274](https://cdn.jsdelivr.net/gh/hx1098/Algorithm@master/img/nacos/20211201205841.png)



#### 2.按照NameSpace + Group + DataID 

 1.下面来进行命名空间的匹配, 用test命名空间为例, 复制下面的uuid, 到项目当中去, 

![image-20211201210306509](https://cdn.jsdelivr.net/gh/hx1098/Algorithm@master/img/nacos/20211201210306.png)

```yaml
#application.yml文件

spring:
  application:
    name: nacos-config-client
  cloud:
    nacos:
      discovery:
        server-addr: localhost:8848 #nacos作为配置中心
      config: #开启配置中心, 进行拉取配置
        server-addr: localhost:8848
        file-extension: yaml #配置中兴指定yml配置
        group: DEV_GROUP #增加分组
        namespace: a013011c-766d-40cb-bcd0-43ba73560b72 #      指定命名空间    
```



```yaml
#bootstrap.yml文件指定dev环境:

spring:
  profiles:
    active: dev
#    active: test
#    active: info
```



2.新建三个config,

```yaml
Data ID: nacos-config-client-dev.yaml
Group: DEFAULT_GROUP

config: 
    info: namespace:a013011c-766d-40cb-bcd0-43ba73560b72d, DEFAULT_GROUP分组,  nacos-config-client-dev.yaml
```



```
Data ID: nacos-config-client-dev.yaml
Group: DEV_GROUP

config: 
    info: namespace:a013011c-766d-40cb-bcd0-43ba73560b72d, DEV_GROUP分组,  nacos-config-client-dev.yaml
```



```
Data ID: nacos-config-client-dev.yaml
Group: TEST_GROUP

config: 
    info: namespace:a013011c-766d-40cb-bcd0-43ba73560b72d, TEST_GROUP分组,  nacos-config-client-dev.yaml
```

![image-20211201211856967](https://cdn.jsdelivr.net/gh/hx1098/Algorithm@master/img/nacos/20211201211857.png)



#### 3.可能会遇到的问题

```
org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'scopedTarget.configClientController': Injection of autowired dependencies failed; nested exception is java.lang.IllegalArgumentException: Could not resolve placeholder 'config.info' in value "${config.info}"
```

这种情况一般是由于你的环境对应不上, 思路: 

1. 看命名空间
2. 看active:dev 触发的环境
3. 看group是否正确
4. 看controller是否写错, 一般这种可能性不大了.

