package com.zminder.wms;

import com.zminder.wms.pojo.Menu;
import com.zminder.wms.pojo.User;
import com.zminder.wms.service.MenuService;
import com.zminder.wms.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
class WmsApplicationTests {
    @Autowired
    private UserService userService;
    @Autowired
    private MenuService menuService;

    @Test
    void contextLoads() {
        User sm = userService.queryByUsername("sm");
        log.info(sm.toString());
    }

    @Test
    public void loadMenu() {
        List<Menu> menus = menuService.queryLowerRole(1);
        log.info(menus.toString());
    }

}
