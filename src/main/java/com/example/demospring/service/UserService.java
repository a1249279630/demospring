package com.example.demospring.service;

import com.example.demospring.pojo.User;
import com.example.demospring.request.UpdateUserStateRequest;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface UserService {

    Integer addUser(User user);

    Integer deleteUser(Integer id);

    Integer updateUser(User user);

    List<User> findAllUser(Integer pageNumber,Integer pageSize);

    Integer updateState(UpdateUserStateRequest updateUserStateRequest, String activeCode);

    User findUserById(int id);

    User findUserByUserNameandUserName(String userName, String password);

    List<User> findUserByActiveCode(String activeCode);
}
