package com.datafly.recommend.reduce;

import com.datafly.recommend.domain.TopProductEntity;
import org.apache.flink.api.common.functions.ReduceFunction;

/**
 * @author XINZE
 */
public class TopProductReduceFunction implements ReduceFunction<TopProductEntity> {
    @Override
    public TopProductEntity reduce(TopProductEntity t1, TopProductEntity t2) {

        TopProductEntity top = new TopProductEntity();
        top.setProductId(t1.getProductId());
        top.setActionTimes(t1.getActionTimes() + t2.getActionTimes());
        return top;
    }
}
