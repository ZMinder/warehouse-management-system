package com.zminder.wms.mapper;

import com.zminder.wms.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    List<User> selectAll();

    User selectByUsername(String username);

    int insert(User user);

    int update(User user);

    int deleteByUsername(String username);

    List<User> fuzzySelect(User fuzzy);

    User selectByUsernameAndPassword(Map<String,Object> map);
}
