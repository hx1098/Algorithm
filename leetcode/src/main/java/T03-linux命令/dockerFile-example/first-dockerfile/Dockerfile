#设置基准镜像
FROM TOMCAT:8973f493aa0a
MAINTAINER hx.com
#这里指向的是容器的工作目录, 如果不存在就会闯将
WORKDIR /usr/local/tomcat/webapps
#第一个是值fiist-dockerfile下的docker-web文件夹, 第二个是指 webapps下的文件夹, 如果不存在就创建
#这一句的功能: 复制目录下的所有文件到容器目录
ADD docker-web ./docker-web
