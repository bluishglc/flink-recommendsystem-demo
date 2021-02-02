package com.datafly.recommend.service.impl;

import com.datafly.recommend.dao.ContactDao;
import com.datafly.recommend.domain.ContactEntity;
import com.datafly.recommend.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("contactService")
public class ContactServiceImpl implements ContactService {

    @Autowired
    ContactDao contactDao;

    @Override
    public List<ContactEntity> selectByIds(List<String> ids) {
        return contactDao.selectByIds(ids);
    }

    @Override
    public ContactEntity selectById(String id) {
        return contactDao.selectById(Integer.valueOf(id));
    }
}
