package com.datafly.recommend.map;

import com.datafly.recommend.client.HbaseClient;
import com.datafly.recommend.util.LogToEntity;
import com.datafly.recommend.domain.LogEntity;
import org.apache.flink.api.common.functions.MapFunction;

/**
 * @author XINZE
 */
public class UserHistoryMapFunction implements MapFunction<String, String> {

    /**
     * 将 用户-产品  和 产品-用户 分别存储Hbase表
     *
     * @param s
     * @return
     * @throws Exception
     */
    @Override
    public String map(String s) throws Exception {
        LogEntity log = LogToEntity.getLog(s);
        if (null != log) {
            HbaseClient.increamColumn("u_history", String.valueOf(log.getUserId()), "p", String.valueOf(log.getProductId()));
            HbaseClient.increamColumn("p_history", String.valueOf(log.getProductId()), "p", String.valueOf(log.getUserId()));
        }
        return "";
    }
}
