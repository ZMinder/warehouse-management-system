package com.zminder.wms.service;

import com.zminder.wms.pojo.User;
import com.zminder.wms.utils.Page;

public interface UserService {

    Page<User> queryPage(int pageSize, int pageNum);
}
