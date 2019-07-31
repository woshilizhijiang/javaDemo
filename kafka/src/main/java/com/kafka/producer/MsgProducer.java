package com.kafka.producer;

import com.kafka.srializer.User;
import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.Serializer;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;
import java.util.concurrent.ExecutionException;

public class MsgProducer {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Properties props = new Properties();

        /******************************必须指定-start**************************************/
        props.put("bootstrap.servers", "127.0.0.1:9093");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put ("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        /******************************必须指定-end***************************************/

        props.put("acks", "-1");
        props.put("retries", 3);
        props.put("batch.size", 16384);
        props.put("linger.ms", 10);
        props.put("buffer.memory", 1024*100);
        props.put("max.block.ms", 3000);
        //自定义分区partitioner.class
//      props.put("partitioner.class","com.kafka.producer.partitioner.MyPartitioner");

        Serializer<String> keySerializer =new StringSerializer();
        Serializer<String> valueSerializer =new StringSerializer();

        Producer<String, String> producer = new KafkaProducer<>(props, keySerializer,valueSerializer) ;
        ProducerRecord<String,String> record;
        for(int i = 0; i < 10; i++) {
            record = new ProducerRecord<>("newTopic", "mykey" + Integer.toString(i) , i+"lyx");
            //相同的key保证落在同一分区
//            record = new ProducerRecord<>("newTopic", "mykey", i+"lyx");
            producer.send(record, new Callback() {
                @Override
                public void onCompletion(RecordMetadata metadata, Exception e) {
                    if (null == e){
                        System.out.println("success，" +metadata );
                    }else {
                        System.out.println("error" + e);
                    }
                }
            });
        }
        producer.close();


//        Producer<String, String> producer= new KafkaProducer<>(props);
//        for(int i = 0; i < 20; i++)
//            //同步
//            producer.send(new ProducerRecord<> ("mytopic", Integer.toString(i), "bbbb"));
//
//            producer.send();
//        producer.close();


//        props.put ("value.serializer","com.kafka.srializer.UserSerializer");
//        String topic = "mytopic";
//        Producer<String, User> producer = new KafkaProducer<String, User>(props);
//        User user = new User("XI", "HU", 33 ,"Beijing,China");
//        ProducerRecord<String, User> record = new ProducerRecord<>(topic, user);
//        producer.send(record).get();
//        producer.close();
        System.out.println("end");

    }
}
