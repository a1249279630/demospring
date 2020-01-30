package com.example.demospring.service.impl;

import com.example.demospring.dao.UserDao;
import com.example.demospring.pojo.User;
import com.example.demospring.request.UpdateUserStateRequest;
import com.example.demospring.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    @Override
    public Integer addUser(User user) {
        return userDao.addUser(user);
    }

    @Override
    public Integer deleteUser(Integer id) {
        return userDao.deleteUser(id);
    }

    @Override
    public Integer updateUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public List<User> findAllUser(Integer pageNumber,Integer pageSize) {
        PageHelper.startPage(pageNumber,pageSize);
        List<User> all=userDao.findAllUser();
        PageInfo<User> pageInfo=new PageInfo<>(all);
        return pageInfo.getList();
    }

    @Override
    public Integer updateState(UpdateUserStateRequest updateUserStateRequest, String activeCode) {
         User user=new User();
         BeanUtils.copyProperties(updateUserStateRequest,user);
         user.setActivecode(activeCode);
         return userDao.updateState(user,activeCode);
    }

    @Override
    public User findUserById(int id) {
        return userDao.findUserById(id);
    }

    @Override
    public User findUserByUserNameandUserName(@Param("username") String username, String password) {
        return userDao.findUserByUserNameandUserName(username,password);
    }

    @Override
    public List<User> findUserByActiveCode(String activeCode) {
        return userDao.findUserByActiveCode(activeCode);
    }


}
