package com.demo.recommend.task;

import com.demo.recommend.map.LogMapFunction;
import com.demo.recommend.util.Property;
import org.apache.flink.api.common.serialization.SimpleStringSchema;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer;

import java.util.Properties;

/**
 * 日志 -> Hbase
 *
 * @author XINZE
 */
public class LogTask {

    public static void main(String[] args) throws Exception {

        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        Properties properties = Property.getKafkaProperties("log");
        DataStreamSource<String> dataStream = env.addSource(new FlinkKafkaConsumer<>("con", new SimpleStringSchema(), properties));
        dataStream.map(new LogMapFunction());

        env.execute("Log message receive");
    }
}
