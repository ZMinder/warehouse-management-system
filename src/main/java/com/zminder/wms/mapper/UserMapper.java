package com.zminder.wms.mapper;

import com.zminder.wms.pojo.User;

import java.util.List;

public interface UserMapper {
    List<User> selectAll();

    User selectByUsername(String username);

    int insert(User user);

    int update(User user);

    int deleteByUsername(String username);
}
