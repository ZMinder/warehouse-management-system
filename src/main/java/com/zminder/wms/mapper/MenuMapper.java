package com.zminder.wms.mapper;

import com.zminder.wms.pojo.Menu;

import java.util.List;

public interface MenuMapper {
     List<Menu> selectLowerRole(int roleId);
}
