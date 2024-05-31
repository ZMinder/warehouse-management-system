package com.zminder.wms.controller;

import com.zminder.wms.pojo.Menu;
import com.zminder.wms.service.MenuService;
import com.zminder.wms.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/menu")
@CrossOrigin
public class MenuController {
    @Autowired
    private MenuService menuService;

    @GetMapping
    public Result<List<Menu>> loadMenu() {
        List<Menu> menus = menuService.queryAll();
        if (menus == null || menus.size() == 0) {
            return Result.fail(null);
        }
        return Result.success(menus);
    }
}
