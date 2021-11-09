
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

## kafka集群搭建:

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



## kafka集群环境下创建topic

```bash
#创建一个topic
./bin/kafka-topics.sh --bootstrap-server node75:9092,node76:9092,node77:9092 --create --topic topic01 --partitions 3 --replication-factor 2
#查看集群下有几个topic
./bin/kafka-topics.sh --bootstrap-server node75:9092,node76:9092,node77:9092 --list
#查看备份
cd /usr/local/kafka/data


#副本因子在每台服务器上都存储了两份
--replication-factor 2
```

node75服务器

![image-20211106102630240](https://cdn.jsdelivr.net/gh/hx1098/Algorithm@master/img/kafka/20211106102630.png)

node76服务器

![image-20211106102716511](https://cdn.jsdelivr.net/gh/hx1098/Algorithm@master/img/kafka/20211106102716.png)

node77服务器

![image-20211106102746226](https://cdn.jsdelivr.net/gh/hx1098/Algorithm@master/img/kafka/20211106102746.png)

## 查看topic

```bash
#查看topic
./bin/kafka-topics.sh --bootstrap-server node75:9092,node76:9092,node77:9092 --describe --topic topic01

```

![image-20211106103400454](https://cdn.jsdelivr.net/gh/hx1098/Algorithm@master/img/kafka/20211106103400.png)



## 创建topic

```bash
./bin/kafka-topics.sh --bootstrap-server node75:9092,node76:9092,node77:9092 --create --topic topic02 --partitions 2 --replication-factor 3
./bin/kafka-topics.sh --bootstrap-server node75:9092,node76:9092,node77:9092 --describe --topic topic02
```

![image-20211106104231480](https://cdn.jsdelivr.net/gh/hx1098/Algorithm@master/img/kafka/20211106104231.png)



## 修改分区

分区只能增加不能减少

```bash
#拿上面的来说, 将其中的分区减少为2, 则会报错
./bin/kafka-topics.sh --bootstrap-server node75:9092,node76:9092,node77:9092 --alter --topic topic02 --partitions 2
#如果增加为3
./bin/kafka-topics.sh --bootstrap-server node75:9092,node76:9092,node77:9092 --alter --topic topic02 --partitions 3
./bin/kafka-topics.sh --bootstrap-server node75:9092,node76:9092,node77:9092 --describe --topic topic02
```

![image-20211106104653223](https://cdn.jsdelivr.net/gh/hx1098/Algorithm@master/img/kafka/20211106104653.png)



## 删除topic

```bash
#删除后实际上只是打了一个delee的标签
./bin/kafka-topics.sh --bootstrap-server node75:9092,node76:9092,node77:9092 --delete --topic topic02
cd /usr/local/kafka-2.11/data
```

![image-20211106105107092](https://cdn.jsdelivr.net/gh/hx1098/Algorithm@master/img/kafka/20211106105107.png)







## 发布与订阅topic

```bash

./bin/kafka-topics.sh --bootstrap-server node75:9092,node76:9092,node77:9092 --create --topic topic01 --partitions 3 --replication-factor 3
./bin/kafka-topics.sh --bootstrap-server node75:9092,node76:9092,node77:9092 --list

#消费者,会卡这一直等待生产者进行生产消息
./bin/kafka-console-consumer.sh --bootstrap-server node75:9092,node76:9092,node77:9092 --topic topic01 --group g1 --property print.key=true --property print.value=true --property key.separator=,
#创建一个生产者
./bin/kafka-console-producer.sh --broker-list node75:9092,node76:9092,node77:9092 --topic topic01
#没能打出一个完美的hello wrold出来, 只能说手残了,
#其中, --property 是非必选的指令, 这里仅仅是打印出来key和value的值出来, 但是这里我们是没办法输入key的值来的, 所以下面的打印是空的key
#生产者要使用的是broker指令了
```

![image-20211107225843615](https://cdn.jsdelivr.net/gh/hx1098/Algorithm@master/img/kafka/20211107225843.png)



![image-20211107225814457](https://cdn.jsdelivr.net/gh/hx1098/Algorithm@master/img/kafka/20211107225821.png)





## javaapi的使用

### 创建删除查询

```java
Properties properties = new Properties();
        /**这里是我的虚拟机的名称*/
        properties.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, "node75:9092,node76:9092,node77:9092");
        KafkaAdminClient adminClient = (KafkaAdminClient) KafkaAdminClient.create(properties);

        //这种是异步的创建, 所以说他返回的时候偶是一个topic
        //adminClient.createTopics(Arrays.asList(new NewTopic("topic02", 3, (short) 3)));

        //同步创建的topic
     /*   CreateTopicsResult topic3 = adminClient.createTopics(Arrays.asList(new NewTopic("topic01", 3, (short) 3)));
        topic3.all().get();*/

        //查看kafka中有多少个topic,
      /*  ListTopicsResult listTopicsResult = adminClient.listTopics();
        Set<String> topicSet = listTopicsResult.names().get();
        for (String s : topicSet) {
            System.out.println(s);
        }*/

        //topic的删除
   /*     DeleteTopicsResult deleteTopicsResult = adminClient.deleteTopics(Arrays.asList("topic01"));
        deleteTopicsResult.all().get();*/



        DescribeTopicsResult topic01 = adminClient.describeTopics(Arrays.asList("topic01"));
        Map<String, TopicDescription> topic01Result = topic01.all().get();
        System.out.println("==========================");
        for (Map.Entry<String, TopicDescription> entry : topic01Result.entrySet()) {
            System.out.println(entry.getKey() + "\t" + entry.getValue());
        }
        System.out.println("==========================");

        //关闭
        adminClient.close();
```



### topic的消费与生产

```java
        //创建kafkaProducer 生产者
        Properties properties = new Properties();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "node75:9092,node76:9092,node77:9092");
        //序列化
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,  StringSerializer.class.getName());

        KafkaProducer<String, String> kafkaProducer = new KafkaProducer<String, String>(properties);
        for (int i = 0; i < 10; i++) {
            ProducerRecord<String, String> topic01 = new ProducerRecord<>("topic01", "第" + i + "次 hello wrold");
            kafkaProducer.send(topic01);

        }

        kafkaProducer.close();
```



```java
 		//创建kafkaConsumer  消费者
        Properties properties = new Properties();
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "node75:9092,node76:9092,node77:9092");
        //消费者需要进行反序列化
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        //消费者的组信息
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, "topic01");
        KafkaConsumer<String, String> kafkaConsumer = new KafkaConsumer<>(properties);
        //    2.订阅相关的Tipics
        kafkaConsumer.subscribe(Pattern.compile("^topic.*"));
        //    遍历消息
        while (true) {
            ConsumerRecords<String, String> consumerRecords = kafkaConsumer.poll(Duration.ofSeconds(10));
            //如果取到了数据
            if (!consumerRecords.isEmpty()) {
                Iterator<ConsumerRecord<String, String>> recordIterator = consumerRecords.iterator();
                while (recordIterator.hasNext()) {
                    ConsumerRecord<String, String> record = recordIterator.next();

                    String topic = record.topic();
                    int partition = record.partition();//哪个分区的消息
                    long offset = record.offset();//在这个消息分区中的偏移量

                    String value = record.value();
                    String key = record.key();
                    long timestamp = record.timestamp();

                    System.out.println(topic + "\t" + "分区:"+partition + ", 偏移量:" + offset + ",key :" + key + ", value:" + value + ", timestamp:" + timestamp) ;
                }
            }
        }
```



同时启动多个消费者时候, 可以看到不同的分区是别均分到不同的消费者的, 可以看到, 在同一个消费者组(topic01)里面, 随着三台消费者的启动, 不同的分区分配到了不同的消费者, 

![image-20211109203847510](https://cdn.jsdelivr.net/gh/hx1098/Algorithm@master/img/kafka/20211109203854.png)



![image-20211109203905061](https://cdn.jsdelivr.net/gh/hx1098/Algorithm@master/img/kafka/20211109203905.png)



![image-20211109203917958](https://cdn.jsdelivr.net/gh/hx1098/Algorithm@master/img/kafka/20211109203918.png)



如果我启动了一个topic2的消费者组, 如果启动了第一个就直接分配到了三个分区.

![image-20211109204213142](https://cdn.jsdelivr.net/gh/hx1098/Algorithm@master/img/kafka/20211109204213.png)







## 自定义分区

