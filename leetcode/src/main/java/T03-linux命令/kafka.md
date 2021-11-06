```bash
#单号版启动
#启动kafka
./bin/kafka-server-start.sh -daemon config/server.properties 
#关闭kafka
./bin/kafka-server-stop.sh 
jps

#kafka帮助
./bin/kafka-topics.sh --help

#partitions 分区  replication-factor 负载因子
./bin/kafka-topics.sh --bootstrap-server centos:9092 --create --topic topic01 --partitions 3 --replica
tion-factor 1


#消费者
./bin/kafka-console-consumer.sh  --bootstrap-server centos:9092 --topic topic01 --group group1
#生产者  输入东西就行了
./bin/kafka-console-producer.sh --broker-list centos:9092 --topic topic01

```

kafka集群搭建:

```shell
#从远程的主机上复制到当前目录文件夹下面
scp -r root@centos:/root/soft/kafaka  /root/soft/kafka/

#时钟同步, 搭建集群时必须要这样, 否则可能会搭建失败
yum install ntp -y 
ntpdate ntp1.aliyun.com
clock -w

#准备好需要安装的zkserver, 和kafka
zk配置如下:
#数据配置文件
#创建数据目录
mkdir /root/data
dataDir=/root/data
#集群配置文件
server.1=node75:2888:3888
server.2=node76:2888:3888
server.3=node77:2888:3888

#将配置好的zk复制到77,76两台服务器
scp -r /usr/local/zk/ node77:/usr/local/
scp -r /usr/local/zk/ node76:/usr/local/

#将每个不同的zk绑定一个id
echo 1 > /root/data/myid
echo 2 > /root/data/myid
echo 3 > /root/data/myid

#启动
usr/local/zk/bin/zkServer.sh start
usr/local/zk/bin/zkServer.sh start
usr/local/zk/bin/zkServer.sh start
#查看
usr/local/zk/bin/zkServer.sh status
usr/local/zk/bin/zkServer.sh start
usr/local/zk/bin/zkServer.sh start


#kafka的配置
vi /kafka/config/server.properties

#这里的地址要改, 我这里主机名称是node76
listeners=PLAINTEXT://node76:9092
#kafka日志
log.dirs=/usr/local/kafka-2.11/data
#zk配置
zookeeper.connect=node75:2181,node76:2181,node77:2181

#配置完之后拷贝给76,77
scp -r kafka-2.11/ node76:/usr/local/
scp -r kafka-2.11/ node77:/usr/local/
#修改另外另个broker_id值和地址,
listeners=PLAINTEXT://node75:9092
borker_id=1 #三台不能相同.

#逐个启动
./usr/local/kafka-2.11/bin/kafka-server-start.sh -daemon usr/local/kafka-2.11/config/server.properties
jps



```

