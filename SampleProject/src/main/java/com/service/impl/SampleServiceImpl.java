package com.service.impl;

import com.dao.UserDao;
import com.dto.DBUser;
import com.form.UserForm;
import com.service.SampleService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * User: Anish
 * Date: 3/18/14
 * Time: 11:14 AM
 */
@Service
public class SampleServiceImpl implements SampleService {
    private UserDao userDao;

    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void saveUser(UserForm userForm) {
        DBUser dbUser = new DBUser();
        BeanUtils.copyProperties(userForm, dbUser);
        userDao.create(dbUser);
    }

    @Resource
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
