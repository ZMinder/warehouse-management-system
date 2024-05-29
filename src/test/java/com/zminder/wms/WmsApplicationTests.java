package com.zminder.wms;

import com.zminder.wms.pojo.User;
import com.zminder.wms.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class WmsApplicationTests {
    @Autowired
    private UserService userService;

    @Test
    void contextLoads() {
        User sm = userService.queryByUsername("sm");
        log.info(sm.toString());
    }

}
