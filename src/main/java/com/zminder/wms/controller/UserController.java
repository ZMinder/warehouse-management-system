package com.zminder.wms.controller;

import com.zminder.wms.pojo.User;
import com.zminder.wms.service.UserService;
import com.zminder.wms.utils.Page;
import com.zminder.wms.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    //分页查询
    @GetMapping
    public Result<Page<User>> queryPage(@RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize,
                                        @RequestParam(name = "pageNum", required = false, defaultValue = "1") int pageNum) {
        Page<User> res = userService.queryPage(pageSize, pageNum);
        return Result.success(res);
    }
}
