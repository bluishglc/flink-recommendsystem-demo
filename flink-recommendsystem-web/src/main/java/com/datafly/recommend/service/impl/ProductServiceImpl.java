package com.datafly.recommend.service.impl;

import com.datafly.recommend.dao.ProductDao;
import com.datafly.recommend.domain.ProductEntity;
import com.datafly.recommend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("productService")
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductDao productDao;

    @Override
    public ProductEntity selectById(String id) {
        return productDao.selectById(Integer.valueOf(id));
    }

    @Override
    public List<ProductEntity> selectByIds(List<String> ids) {
        return productDao.selectByIds(ids);
    }

    @Override
    public List<String> selectInitPro(int topSize) {
        return productDao.selectInitPro(topSize);
    }

}
