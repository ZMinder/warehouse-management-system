package com.zminder.wms.service;

import com.zminder.wms.pojo.User;
import com.zminder.wms.utils.Page;

public interface UserService {

    Page<User> queryPage(int pageSize, int pageNum);

    User queryById(int id);

    int insert(User user);

    int update(User user);
}
