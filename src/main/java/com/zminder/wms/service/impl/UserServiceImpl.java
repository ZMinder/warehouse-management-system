package com.zminder.wms.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zminder.wms.mapper.UserMapper;
import com.zminder.wms.pojo.User;
import com.zminder.wms.service.UserService;
import com.zminder.wms.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public Page<User> fuzzyQuery(int pageSize, int pageNum, User fuzzy) {
        PageHelper.startPage(pageNum, pageSize);//开启分页拦截器
        List<User> users = userMapper.fuzzySelect(fuzzy);
        PageInfo<User> pageInfo = new PageInfo<>(users);
        List<User> userList = pageInfo.getList();//实际查询的用户集合
        int realPageSize = userList.size();
        int realPageNum = pageInfo.getPageNum();
        long total = pageInfo.getTotal();
        return new Page<>(realPageSize, realPageNum, total, userList);
    }

    @Override
    public User login(String username, String password) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("username", username);
        map.put("password", password);
        User user = userMapper.selectByUsernameAndPassword(map);
        return user;
    }

    @Override
    @Transactional(readOnly = true)
    public Page<User> queryPage(int pageSize, int pageNum) {
        PageHelper.startPage(pageNum, pageSize);//开启分页拦截器
        List<User> users = userMapper.selectAll();//执行查询操作
        //为了获取实际获取的分页信息，要new PageInfo() 因为users实际返回之前对数据进行了封装
        //实际返回的是List的子类
        PageInfo<User> userPageInfo = new PageInfo<>(users);
        int realPageNum = userPageInfo.getPageNum();//获取当前页码
        List<User> userList = userPageInfo.getList();//获取当前页的记录列表
        int realPageSize = userList.size();//获取当前页的实际条数
        long total = userPageInfo.getTotal();//总记录数
        return new Page<>(realPageSize, realPageNum, total, userList);
    }

    @Override
    public User queryByUsername(String username) {
        User user = userMapper.selectByUsername(username);
        return user;
    }


    @Override
    public int saveUser(User user) {
        int res = userMapper.insert(user);
        return res;
    }

    @Override
    public int modify(User user) {
        int res = userMapper.update(user);
        return res;
    }

    @Override
    public int removeByUsername(String username) {
        int res = userMapper.deleteByUsername(username);
        return res;
    }
}
