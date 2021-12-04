[TOC]

## 1.集群的模式

**1.单身狗模式**

**2.集群模式(生产环境, 确保高可用)**

**3.多集群模式-用于数据中心场景**



集群模式(从官网盗个图嘿嘿!)

https://nacos.io/zh-cn/docs/cluster-mode-quick-start.html

![deployDnsVipMode.jpg](https://nacos.io/img/deployDnsVipMode.jpg)

## 2.数据库切换

https://nacos.io/zh-cn/docs/deployment.html, 官网啥都有, 不做搬运工了

1.在配置文件: nacos/conf 文件夹下找到nacos-myusql.sql 的文件, 去数据库执行,并修改application.properties文件

![image-20211204164438480](https://cdn.jsdelivr.net/gh/hx1098/Algorithm@master/img/nacos/20211204164445.png)

```properties
#将下面的数据直接粘贴进行或者将注释放开就行了, 更改用户名和密码
#*************** Config Module Related Configurations ***************#
### If use MySQL as datasource:
spring.datasource.platform=mysql

### Count of DB:
db.num=1

### Connect URL of DB:
db.url.0=jdbc:mysql://127.0.0.1:3306/nacos_config?characterEncoding=utf8&connectTimeout=1000&socketTimeout=3000&autoReconnect=true&useUnicode=true&useSSL=false&serverTimezone=UTC
db.user.0=nacos
db.password.0=nacos

### Connection pool configuration: hikariCP
db.pool.config.connectionTimeout=30000
db.pool.config.validationTimeout=10000
db.pool.config.maximumPoolSize=20
db.pool.config.minimumIdle=2
```

最后重启: 

```bash
#window
startup.cmd -m standalone
```



2.添加一个配置之后, 在数据库中可以可到一个配置增加到数据库中去了OK, 搞定!

![image-20211204164728642](https://cdn.jsdelivr.net/gh/hx1098/Algorithm@master/img/nacos/20211204164728.png)

![image-20211204164744884](https://cdn.jsdelivr.net/gh/hx1098/Algorithm@master/img/nacos/20211204164744.png)

