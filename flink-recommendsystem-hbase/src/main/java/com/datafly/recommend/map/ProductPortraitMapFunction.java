package com.datafly.recommend.map;

import com.datafly.recommend.client.HbaseClient;
import com.datafly.recommend.client.MysqlClient;
import com.datafly.recommend.util.AgeUtil;
import com.datafly.recommend.util.LogToEntity;
import com.datafly.recommend.domain.LogEntity;
import org.apache.flink.api.common.functions.MapFunction;

import java.sql.ResultSet;

/**
 * @author XINZE
 */
public class ProductPortraitMapFunction implements MapFunction<String, String> {
    @Override
    public String map(String s) throws Exception {
        LogEntity log = LogToEntity.getLog(s);
        ResultSet rst = MysqlClient.selectUserById(log.getUserId());
        if (rst != null) {
            while (rst.next()) {
                String productId = String.valueOf(log.getProductId());
                String sex = rst.getString("sex");
                HbaseClient.increamColumn("prod", productId, "sex", sex);
                String age = rst.getString("age");
                HbaseClient.increamColumn("prod", productId, "age", AgeUtil.getAgeType(age));
            }
        }
        return null;
    }
}
