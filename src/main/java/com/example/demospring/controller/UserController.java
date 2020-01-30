package com.example.demospring.controller;

import com.example.demospring.pojo.User;
import com.example.demospring.request.UpdateUserStateRequest;
import com.example.demospring.service.UserService;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping(value = "find/all/user")
    public List<User> findAllUser(@RequestBody Integer pageNumber,Integer pageSize){

        return userService.findAllUser(pageNumber,pageSize);
    }

    /**
     * 通过form表单提交
     * @param user
     * @return
     */
    @PostMapping(value = "add/user")
    public Integer addUser(@RequestBody User user){
        return userService.addUser(user);
    }
    /**
     * 通过json提交
     * @param
     * @return
     */
    @PostMapping(value = "add/user/by/json")
    public Integer addUserByJson(@RequestBody User user){
        return userService.addUser(user);
    }


    @DeleteMapping(value = "delete/user/by/id")
    public Integer deleteUser(@RequestBody Integer id) {
        return userService.deleteUser(id);
    }

    /*@PutMapping(value = "update/user/by/user")
    public Integer updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }*/

    @PostMapping(value = "update/userState/by/acticeCode")
    public Integer updateState(@RequestBody UpdateUserStateRequest updateUserStateRequest, String activeCode){
        return userService.updateState(updateUserStateRequest,activeCode);
    }

    @GetMapping(value = "find/user/by/id")
    public User findUserById(int id){
        return userService.findUserById(id);
    }

    @GetMapping(value = "fing/user/by/usernameAndpassward")
    public User findUserByUserNameandUserName(String username, String password){
        return userService.findUserByUserNameandUserName(username,password);
    }

    @GetMapping(value = "fing/user/by/activeCode")
    public List<User> findUserByActiveCode(String activeCode){
        return userService.findUserByActiveCode(activeCode);
    }
}
