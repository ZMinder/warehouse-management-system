package com.zminder.wms.mapper;

import com.zminder.wms.pojo.User;

import java.util.List;

public interface UserMapper {
    List<User> queryAll();

    User queryById(int id);

    int insert(User user);
}
