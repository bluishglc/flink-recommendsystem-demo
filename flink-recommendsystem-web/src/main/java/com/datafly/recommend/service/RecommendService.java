package com.datafly.recommend.service;

import com.datafly.recommend.domain.ProductScoreEntity;
import com.datafly.recommend.dto.ProductDto;

import java.io.IOException;
import java.util.List;

public interface RecommendService {


    /**
     * 弃用
     * <p>
     * 基于用户特征的热度表和产品标签关联表 -> 联合推荐
     *
     * @param userId
     * @return
     * @throws IOException
     */
    List<ProductScoreEntity> userRecommend(String userId) throws IOException;

    /**
     * 热度榜数据
     */
    List<ProductDto> recommendByHotList();

    /**
     * 协同过滤推荐结果
     *
     * @return
     */
    List<ProductDto> recommendByItemCfCoeff() throws IOException;

    /**
     * 产品画像推荐结果
     *
     * @return
     */
    List<ProductDto> recommendByProductCoeff() throws IOException;
}
