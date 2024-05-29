package com.zminder.wms.mapper;

import com.zminder.wms.pojo.User;

import java.util.List;

public interface UserMapper {
    List<User> selectAll();


    int insert(User user);

    int update(User user);

    int deleteByUsername(String username);

    List<User> fuzzySelect(User fuzzy);
}
