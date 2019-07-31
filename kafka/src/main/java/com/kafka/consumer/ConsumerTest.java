package com.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Arrays;
import java.util.Properties;

public class ConsumerTest {
    public static void main(String[] args) {
        String topicName = "newTopic";
        String groupID = "test-group";

        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9093");
        props.put("group.ip", groupID);
        props.put("enable.auto.commit", "false");
        props.put("auto.commit.interval.ms", "1000");
        props.put("auto.offset.reset", "earliest");

        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");


        KafkaConsumer<String,String> consumer = new KafkaConsumer<String, String>(props);
        consumer.subscribe(Arrays.asList(topicName));
        try {
            while (true){
                ConsumerRecords<String, String> records = consumer.poll(1000);
                for (ConsumerRecord<String, String> record:records) {
                    System.out.printf(
                            "offset =%d, key =%s, value =%s%n",
                            record. offset() ,
                            record. key () ,
                            record. value() ) ;
                }
            }
        }finally {
            consumer.close();
        }


    }
}
