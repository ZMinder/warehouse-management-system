package com.zminder.wms.service;

import com.zminder.wms.pojo.User;
import com.zminder.wms.utils.Page;

public interface UserService {

    Page<User> queryPage(int pageSize, int pageNum);

    User queryByUsername(String username);

    int saveUser(User user);

    int modify(User user);

    int removeByUsername(String username);

    Page<User> fuzzyQuery(int pageSize, int pageNum, User fuzzy);

    User login(String username, String password);
}
