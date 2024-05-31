package com.zminder.wms.service;

import com.zminder.wms.pojo.Menu;

import java.util.List;

public interface MenuService {
    List<Menu> queryLowerRole(int roleId);
}
