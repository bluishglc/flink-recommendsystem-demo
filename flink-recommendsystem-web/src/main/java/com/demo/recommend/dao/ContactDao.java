package com.demo.recommend.dao;

import com.demo.recommend.domain.ContactEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ContactDao {

    ContactEntity selectById(@Param("id") int id);

    List<ContactEntity> selectByIds(@Param("ids") List<String> ids);
}
