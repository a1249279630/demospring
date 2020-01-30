package com.example.demospring.dao;

import com.example.demospring.mapper.UserMapper;
import com.example.demospring.pojo.User;
import com.example.demospring.pojo.UserExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDao {
    @Autowired
    private UserMapper userMapper;

    public List<User> findAllUser(){
        UserExample userExample=new UserExample();
        return userMapper.selectByExample(userExample);
    }
    /*通过激活码修改状态然后返回用户*/
    public Integer updateState(User user,String activeCode)  {
        UserExample userExample=new UserExample();
        userExample.createCriteria().andActivecodeEqualTo(activeCode);
        user.setState(1);
        return (Integer) userMapper.updateByExampleSelective(user,userExample);
    }

    public List<User> findUserByActiveCode(String activeCode){
        UserExample userExample=new UserExample();
        userExample.createCriteria().andActivecodeEqualTo(activeCode);
        return  userMapper.selectByExample(userExample);
    }

    public User findUserById(int id){
        return userMapper.selectByPrimaryKey(id);
    }

    public User findUserByUserNameandUserName(@Param("username") String username, String password){
        UserExample userExample = new UserExample();
        return userMapper.loginUser(username, password);
    }

    public Integer addUser(User user){
        return userMapper.insert(user);
    }

    public Integer deleteUser(int id){
        return userMapper.deleteByPrimaryKey(id);
    }
    public Integer updateUser(User user){
        return userMapper.updateByPrimaryKey(user);
    }
}
