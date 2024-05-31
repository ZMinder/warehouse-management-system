package com.zminder.wms.service.impl;

import com.zminder.wms.mapper.MenuMapper;
import com.zminder.wms.pojo.Menu;
import com.zminder.wms.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuMapper menuMapper;

    @Override
    @Transactional(readOnly = true)
    public List<Menu> queryLowerRole(int roleId) {
        return menuMapper.selectLowerRole(roleId);
    }

    @Override
    public List<Menu> queryAll() {
        return menuMapper.selectAll();
    }
}
