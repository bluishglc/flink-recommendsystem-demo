package com.demo.recommend;


import com.demo.recommend.dao.ProductDao;
import com.demo.recommend.domain.ProductEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Rollback
public class ProductDaoTest {

    @Autowired
    ProductDao productDao;

    @Test
    public void testSelect() {
        ProductEntity productEntity = productDao.selectById(5);
        System.out.println(productEntity);
    }
}
