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
@CrossOrigin
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
    @GetMapping("/{username}")
    public Result<User> queryByUsername(@PathVariable("username") String username) {
        User user = userService.queryByUsername(username);
        if (null == user) {//如果查询不到
            return Result.error(ResultCode.USER_NOT_EXISTS, user);
        }
        return Result.success(user);
    }

    //新增用户
    @PostMapping
    public Result<Integer> saveUser(@RequestBody User user) {
        int res = userService.saveUser(user);
        if (res == 0) {//新增失败
            return Result.fail(res);
        }
        return Result.success(res);
    }

    //更新用户信息
    @PutMapping
    public Result<Integer> modifyUser(@RequestBody User user) {
        int res = userService.modify(user);
        if (res == 0) {//当前数据库不存在该用户
            return Result.error(ResultCode.USER_NOT_EXISTS, res);
        }
        return Result.success(res);
    }

    //根据id删除用户
    @DeleteMapping("/{username}")
    public Result<Integer> removeUser(@PathVariable("username") String username) {
        int res = userService.removeByUsername(username);
        if (res == 0) {//用户不存在
            return Result.error(ResultCode.USER_NOT_EXISTS, res);
        }
        return Result.success(res);
    }

    //模糊查询
    @GetMapping("/fuzzy")
    public Result<Page<User>> fuzzyQuery(@RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize,
                                         @RequestParam(name = "pageNum", required = false, defaultValue = "1") int pageNum,
                                         @RequestParam(value = "keywords", required = false) String keywords) {
        Page<User> page = userService.fuzzyQuery(pageSize, pageNum, keywords);
        return Result.success(page);
    }
}
