package com.zminder.wms.service.impl;

import com.zminder.wms.mapper.UserMapper;
import com.zminder.wms.pojo.User;
import com.zminder.wms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    @Transactional(readOnly = true)
    public List<User> showAll() {
        return userMapper.showAll();
    }
}
