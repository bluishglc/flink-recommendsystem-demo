package com.demo.recommend.map;

import com.demo.recommend.domain.LogEntity;
import com.demo.recommend.util.LogToEntity;
import org.apache.flink.api.common.functions.MapFunction;

/**
 * 将kafka 的数据 转为 Log类
 */
public class GetLogFunction implements MapFunction<String, LogEntity> {
    @Override
    public LogEntity map(String s) throws Exception {

        LogEntity log = LogToEntity.getLog(s);
        return log;
    }
}
