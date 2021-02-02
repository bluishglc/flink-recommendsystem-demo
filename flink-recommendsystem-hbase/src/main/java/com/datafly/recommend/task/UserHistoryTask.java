package com.datafly.recommend.task;

import com.datafly.recommend.util.Property;
import com.datafly.recommend.map.UserHistoryMapFunction;
import org.apache.flink.api.common.serialization.SimpleStringSchema;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer;

import java.util.Properties;

public class UserHistoryTask {

    public static void main(String[] args) throws Exception {

        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        Properties properties = Property.getKafkaProperties("history");
        DataStreamSource<String> dataStream = env.addSource(new FlinkKafkaConsumer<>("con", new SimpleStringSchema(), properties));
        dataStream.map(new UserHistoryMapFunction());

        env.execute("User Product History");
    }
}
