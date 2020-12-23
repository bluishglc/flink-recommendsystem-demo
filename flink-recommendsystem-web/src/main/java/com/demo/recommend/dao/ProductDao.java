package com.demo.recommend.dao;

import com.demo.recommend.domain.ProductEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProductDao {

    ProductEntity selectById(@Param("id") int id);

    List<ProductEntity> selectByIds(@Param("ids") List<String> ids);

    List<String> selectInitPro(@Param("size") int size);
}
