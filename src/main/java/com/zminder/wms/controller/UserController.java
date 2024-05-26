package com.zminder.wms.controller;

import com.zminder.wms.pojo.User;
import com.zminder.wms.service.UserService;
import com.zminder.wms.utils.Page;
import com.zminder.wms.utils.Result;
import com.zminder.wms.utils.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    //分页查询
    @GetMapping
    public Result<Page<User>> queryPage(@RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize, @RequestParam(name = "pageNum", required = false, defaultValue = "1") int pageNum) {
        Page<User> res = userService.queryPage(pageSize, pageNum);
        return Result.success(res);
    }

    //根据id查询
    @GetMapping("/{id}")
    public Result<User> queryById(@PathVariable("id") int id) {
        User user = userService.queryById(id);
        if (null == user) {//如果查询不到
            return Result.error(ResultCode.USER_NOT_EXISTS, user);
        }
        return Result.success(user);
    }

    //新增用户
    @PostMapping
    public Result<Integer> saveUser(@RequestBody User user) {
        int res = userService.insert(user);
        if (res == 0) {//新增失败
            return Result.fail(res);
        }
        return Result.success(res);
    }

    //更新用户信息
    @PutMapping
    public Result<Integer> modifyUser(@RequestBody User user) {
        int res = userService.update(user);
        if (res == 0) {//当前数据库不存在该用户
            return Result.error(ResultCode.USER_NOT_EXISTS, res);
        }
        return Result.success(res);
    }
}
