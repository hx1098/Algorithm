## 1.docker 基础命令
docker 官网
https://hub.docker.com/
```shell
docker rm -f xxx #删除强制删除容器
docker rmi -f xxx #删除镜像
docker pull xxx #拉取容器 
docker images #查看镜像

#编辑json
vi /etc/docker/daemon.json
#重加在daemon.json
sudo systemctl daemon-reload
#重启docker
sudo systemctl restart docker
```


## 2.docker tomcat命令
```shell
docker pull tomcat:8.5-jdk8-corretto
docker images
docker run -p 8000:8080 8973f493aa0a
netstat -tunlp|grep 8000

#进入容器
docker exec -it 2632acc2a00b /bin/bash
cat /proc/version
#退出容器
exit 

#进入存放的容器地方
cd /var/lib/docker/
```


## 3. dockerfile 
dockerfile是一个包含用于组合镜像的命令
```shell
FROM TOMCAT:LATEST    #设置基准镜像
MAINTAINER hx.com     #那个人活着那个机构维护的
WORKDIR /usr/local/tomcat/webapps   #用于切换工作目录
ADD docker-web ./docker-web    #复制到指定的镜像目录下
```

## 4. 将写好的dockerfile文件上传到服务器上去
如下图所示: docker-web中增加一个index.html文件, 写上几个数字即可
![image-20220115152440287](https://cdn.jsdelivr.net/gh/hx1098/Algorithm@master/img/algorthm/20220115152447.png)

dockerfile 文件:如下:

```shell

#设置基准镜像
FROM tomcat:8.5.46
MAINTAINER hx.com
#这里指向的是容器的工作目录, 如果不存在就会闯将
WORKDIR /usr/local/tomcat/webapps
#第一个是值fiist-dockerfile下的docker-web文件夹, 第二个是指 webapps下的文件夹, 如果不存在就创建
#这一句的功能: 复制目录下的所有文件到容器目录
ADD docker-web ./docker-web
```

build命令:

```
docker build -t hx.com/mywebapp:1.0 /usr/image/first-dockerfile/
或者
docker build -t hx.com/mywebapp:8.5 .
```

run命令:

```
docker run -d -p 8001:8080 hx.com/mywebapp:8.5
```

访问:

http://192.168.190.132:8001/docker-web/index.html



```
FROM CENTOS
FORM SCRATCH 
FROM TOMCAT:9.0.22
LABLE version = "1.0"
ADD hello / #复制到跟路径
ADD test.tar.gz / #添加跟目录并解压
ADD 除了复制, 还具有添加远程文件的功能
ENV JAVA_HOME /usr/local/openjdk8
ENV ${JAVA_HOME}/bin/java -jar test.jar

```



RUN & CMD & ENTRYPOINT

```shell
RUN : 在build构建时是执行命令 
ENTRYPOINT: 容器启动时候执行的命令(一定会被运行的)
CMD: 容器启动后欧之星默认的命令或者参数

```

RUN 

```shell
RUN yum install -y vim #Shell #命令格式, 子进程命令退出不会对父进程产生影响
RUN ["yum", "install", "-y", "vim"]  #exec命令格式, 
```

CMD

```
CMD用于设置默认执行的命令
如Dockerfile中出现多个CMD, 则只有最后一个被执行
如容器启动时附加指令, 则CMD被忽略
CMD ["ps","-ef"] #推荐使用exec格式
```



build 

```
FROM centos
RUN ["echo","image building!!!!"]
CMD ["echo","contraner starting.."]

docker build -t hx.com/docker_run .

```



## 5.redis镜像构建

```shell
FROM centos
RUN ["yum","install","-y","gcc-c++","net-tools","make"]
WORKDIR /usr/local
ADD redis-4.0.14.tar.gz .
WORKDIR /usr/local/redis-4.0.14/src
RUN make && make install
WORKDIR /usr/local/redis-4.0.14
ADD redis-7000.conf .
EXPOSE 7000
CMD ["redis-server","redis-7000.conf"]



#开始构建
docker build -t hx.com/docker-redis .
#运行

```



## 6.容器之间单向通信

docker环境中的虚拟ip, 每个docker环境下创建容器后都会创建一个虚拟的ip, 这个ip无法从外侧直接访问, 只能从docker环境中批次内部通讯的一种标识,  docker虚拟ip之间的访问有很大的局限性

```
docker inspect containID

#其中link, 进入容器中可以ping通,
docker run -d --name web --link database tomcat

```

## 7.网桥双向通信

网桥是虚拟出来的组件,

```shell
 #创建两个容器
 docker run -d --name web tomcat
 docker run -d -it --name database centos /bin/bash
 
 #查看当前的网桥
 docker network ls 
 #创建一个自己的网桥
 docker network create -d bridge my-bridge
 #将web容器与网桥my-bridge绑定
 docker network connect my-bridge web
 #将database容器与网桥my-bridge绑定
 docker network  connect my-bridge database 
 
 #进入database容器之后, ping web容器, 就可以ping 成功
 docker exec -it database  /bin/bash
 ping web

```

​	

## 8.Volume数据卷

既容器存储数据的地方, 可以是容器内部也可以是宿主机的磁盘上.

1.挂载

![image-20220115224159723](https://cdn.jsdelivr.net/gh/hx1098/Algorithm@master/img/algorthm/20220115224159.png)

```shell
docker run --name t1 -v /usr/weabpps:/usr/local/tomcat/webapps tomcat
#实例: 
docker run --name t1 -p 8000:8080 -d -v /usr/webapps/:/usr/local/tomcat/webapps tomcat
#访问: (注意: volume-test 这里的volume-test是文件夹名称)
http://192.168.190.132:8000/volume-test/index.html


```

2.创建共享容器

```shell
#创建共享容器(设置挂在信息)
docker create --name webpage
  -v /webapps:/tomcat/webapps tomcat /bin/true
#共享容器挂载点( )
docker run --volumes-from webpage --name t1 -d tomcat


##实例:(/bin/true实际上就是占位符)
docker create --name webpage -v /usr/webapps/:/usr/local/tomcat/webapps tomcat /bin/true
#使用数据卷
docker run -p 8002:8080 --volumes-from webpage --name  t3 -d tomcat
```



## 9.Docker-compose介绍与安装

1. Docker-compase 是单机多容器部署工具

2. 通过yml文件定义多容器如何部署

3. WIN/MAC默认提供Docker Compose,Linux需安装

### 1. 安装compose

```shell
#安装docker-compose 这里不要使用docker官方的, 太慢, 切换版本就行了, 不要安装版本太高的, 29.2可能后续会build失败
sudo curl -L https://get.daocloud.io/docker/compose/releases/download/1.26.2/docker-compose-`uname -s`-`uname -m`  > /usr/local/bin/docker-compose

# 授权
sudo chmod +x /usr/local/bin/docker-compose
#查看是否安装成功
docker-compose -version
```

### 2.安装wordpress

```
cd /usr
mkdir wordpress
cd wordpress/
vim docker-compose.yml
```

写入如下内容:

```yaml
version: "3.9"
    
services:
  db:
    image: mysql:5.7
    volumes:
      - db_data:/var/lib/mysql
    restart: always
    environment:
      MYSQL_ROOT_PASSWORD: somewordpress
      MYSQL_DATABASE: wordpress
      MYSQL_USER: wordpress
      MYSQL_PASSWORD: wordpress
    
  wordpress:
    depends_on:
      - db
    image: wordpress:latest
    volumes:
      - wordpress_data:/var/www/html
    ports:
      - "8000:80"
    restart: always
    environment:
      WORDPRESS_DB_HOST: db
      WORDPRESS_DB_USER: wordpress
      WORDPRESS_DB_PASSWORD: wordpress
      WORDPRESS_DB_NAME: wordpress
volumes:
  db_data: {}
  wordpress_data: {}
```



```shell
#对wordpress进行编排, 
docker-compose up -d
#之后进行访问即可
```



## 10. docker-compose实战

![image-20220116094941078](https://cdn.jsdelivr.net/gh/hx1098/Algorithm@master/img/algorthm/20220116094941.png)

### 1.构建java代码的镜像

我的项目基础目录, 在这个目录下创建Dockerfie文件, 设置基准镜像, 

去官网搜索 java8

https://hub.docker.com/

Dockerfile文件内容如下:

```
FROM openjdk:8u222-jre
WORKDIR /usr/local/bsbdj
ADD bsbdj.jar .
ADD application.yml .
ADD application-dev.yml .
EXPOSE 80
CMD ["java","-jar","bsbdj.jar"]

```

```shell
#构建镜像
docker build -t hx/bsbdj-app .

```

![image-20220116100531631](https://cdn.jsdelivr.net/gh/hx1098/Algorithm@master/img/algorthm/20220116100531.png)



### 2.构建数据库的镜像

去官网搜索mysql57

```
#数据库目录下创建一个文件
vim Dockerfile
```

文件内容如下:

```
FROM mysql:5.7
WORKDIR /docker-entrypoint-initdb.d
ADD init-db.sql .

```

执行命令

```
docker build -t hx/bsbdj-db .
```

https://hub.docker.com/_/mysql

 **Initializing a fresh instance**

When a container is started for the first time, a new database with the specified name will be created and initialized with the provided configuration variables. Furthermore, it will execute files with extensions `.sh`, `.sql` and `.sql.gz` that are found in `/docker-entrypoint-initdb.d`. Files will be executed in alphabetical order. You can easily populate your `mysql` services by [mounting a SQL **dump into that directory**](https://docs.docker.com/engine/tutorials/dockervolumes/#mount-a-host-file-as-a-data-volume) and provide [custom images](https://docs.docker.com/reference/builder/) with contributed data. SQL files will be imported by default to the database specified by the `MYSQL_DATABASE` variable.

```
#初始化数据库
docker run -d  -e MYSQL_ROOT_PASSWORD=root hx/bsbdj-db

#验证, 看是否能连上数据库,
docker exec -it 1929bf16f316e978235ed328118bbe5395b2c44623def6511c9c79e78cf7815c /bin/bash
mysql -uroot -proot
use bsbdj
show tables
select * from tables

```



### 3. docker-compose.yml

上面两个都是独立的容器, 下面实现交互, 在如下文件夹下面建立一个docker-compose.yml文件

![image-20220116142916284](https://cdn.jsdelivr.net/gh/hx1098/Algorithm@master/img/algorthm/20220116142916.png)

```

vim docker-compose.yml

```

文件内容如下:

```yaml
version: '3.3' #版本号
services:
  db: #可自行命命名
    build: ./bsbdj-db/ #创建bsdbj-db服务
    restart: always #如果宕机自动创建容器并重启
    environment: #设置环境变量
      MYSQL_ROOT_PASSWORD: root
  app:
    build: ./bsbdj-app/
    depends_on:
      - db
    ports:
      - "80:80"
    restart: always

```

执行如何命令:

```shell
#后台执行命令
docker-compose up -d
#查看日志
docker-compose logs
#会查看到日志, 退出后容器也停止
docker-compose up 
#下线
docker-compose down
```

此时数据库连接时候需要修改:

```yml

spring:
  datasource:
    driver-class-name: com.mysql.jdbc.Driver
    #这里的 localhost://3306 要改为 容器名: db
    url: jdbc:mysql://db:3306/bsbdj?useUnicode=true
    username: root
    password: root

```

