```bash

#启动kafka
./bin/kafka-server-start.sh -daemon config/server.properties 
jps
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

