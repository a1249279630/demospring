package com.example.demospring.controller;

import com.example.demospring.pojo.User;
import com.example.demospring.request.RegistUserRequest;
import com.example.demospring.request.UpdateUserPasswardRequest;
import com.example.demospring.request.UpdateUserRequest;
import com.example.demospring.request.UpdateUserStateRequest;
import com.example.demospring.service.UserService;
import org.apache.ibatis.annotations.Param;
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
     * @param
     * @return
     */
    @PostMapping(value = "add/user")
    public Integer addUser(@RequestBody RegistUserRequest registUserRequest){
        return userService.addUser(registUserRequest);
    }
    /**
     * 通过json提交
     * @param
     * @return
     */
    @PostMapping(value = "add/user/by/json")
    public String addUserByJson(@RequestBody RegistUserRequest registUserRequest){
        Integer integer = userService.addUser(registUserRequest);
        if(integer==1){
            return "注册成功";
        }else{
            return "注册失败，用户名重复";
        }
    }


    @DeleteMapping(value = "delete/user/by/id")
    public String deleteUser(@RequestBody Integer id) {
        Integer integer = userService.deleteUser(id);
        if(integer==1){
            return "删除成功";
        }else{
            return "删除失败，该用户名下有订单";
        }
    }

    @PostMapping(value = "update/user/by/id")
    public Integer updateUser(@RequestBody UpdateUserRequest updateUserRequest,Integer id) {
        return userService.updateUser(updateUserRequest,id);
    }

    @PostMapping(value = "update/userState/by/acticeCode")
    public Integer updateState(@RequestBody UpdateUserStateRequest updateUserStateRequest, String activeCode){
        return userService.updateState(updateUserStateRequest,activeCode);
    }

    @GetMapping(value = "find/user/by/id")
    public User findUserById(@RequestBody int id){
        return userService.findUserById(id);
    }

    @GetMapping(value = "fing/user/by/usernameAndpassward")
    public User findUserByUserNameandPassword(String username, String password){
        return userService.findUserByUserNameandPassword(username,password);
    }

    @GetMapping(value = "fing/user/by/activeCode")
    public List<User> findUserByActiveCode(@RequestBody String activeCode){
        return userService.findUserByActiveCode(activeCode);
    }

    @PostMapping(value = "update/psssward/by/username")
    public String UpdateUserPassword(@RequestBody UpdateUserPasswardRequest updateUserPasswardRequest){
        Integer integer = userService.updateUserPassword(updateUserPasswardRequest);
        if(integer==1){
            return "密码更改成功！";
        }else if(integer==0){
            return "两次输入的密码不一致";
        }else if(integer==-1){
            return "新密码不能与旧密码一样";
        }else if(integer==-2){
            return "安全码错误，请输入正确的安全码！";
        }else return "服务器错误";
    }
}
