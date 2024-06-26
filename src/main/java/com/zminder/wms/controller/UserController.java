package com.zminder.wms.controller;

import com.zminder.wms.pojo.Menu;
import com.zminder.wms.pojo.User;
import com.zminder.wms.service.MenuService;
import com.zminder.wms.service.UserService;
import com.zminder.wms.utils.Page;
import com.zminder.wms.utils.Result;
import com.zminder.wms.utils.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private MenuService menuService;

    //分页查询
    @GetMapping
    public Result<Page<User>> queryPage(@RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize,
                                        @RequestParam(name = "pageNum", required = false, defaultValue = "1") int pageNum) {
        Page<User> res = userService.queryPage(pageSize, pageNum);
        return Result.success(res);
    }

    @GetMapping("/{username}")
    public Result<User> queryByUsername(@PathVariable("username") String username) {
        User user = userService.queryByUsername(username);
        if (null == user) {
            return Result.error(ResultCode.USER_NOT_EXISTS, null);
        }
        return Result.success(user);
    }

    @PostMapping("/login")
    public Result<HashMap> login(@RequestBody User user) {
        User queryUser = userService.login(user.getUsername(), user.getPassword());
        if (null == queryUser) {
            return Result.error(ResultCode.USER_NOT_EXISTS, null);
        }
        queryUser.setPassword(null);
        List<Menu> menus = menuService.queryLowerRole(queryUser.getRoleId());
        HashMap<String, Object> res = new HashMap<>();
        res.put("user", queryUser);
        res.put("menu", menus);
        return Result.success(res);
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

    //根据账号删除用户
    @DeleteMapping("/{username}")
    public Result<Integer> removeUser(@PathVariable("username") String username) {
        int res = userService.removeByUsername(username);
        if (res == 0) {//用户不存在
            return Result.error(ResultCode.USER_NOT_EXISTS, res);
        }
        return Result.success(res);
    }

    //模糊查询
    @PostMapping("/fuzzy")
    public Result<Page<User>> fuzzyQuery(@RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize,
                                         @RequestParam(name = "pageNum", required = false, defaultValue = "1") int pageNum,
                                         @RequestBody User fuzzy) {
        Page<User> page = userService.fuzzyQuery(pageSize, pageNum, fuzzy);
        return Result.success(page);
    }
}
