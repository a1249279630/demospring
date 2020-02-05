package com.example.demospring.service;

import com.example.demospring.pojo.User;
import com.example.demospring.request.RegistUserRequest;
import com.example.demospring.request.UpdateUserPasswardRequest;
import com.example.demospring.request.UpdateUserRequest;
import com.example.demospring.request.UpdateUserStateRequest;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface UserService {

    Integer addUser(RegistUserRequest registUserRequest);

    Integer deleteUser(Integer id);

    Integer updateUser(UpdateUserRequest updateUserRequest, Integer id);

    List<User> findAllUser(Integer pageNumber,Integer pageSize);

    Integer updateState(String activeCode);

    User findUserById(int id);

    String findUserByUserNameandPassword(String userName, String password);

    List<User> findUserByActiveCode(String activeCode);

    Integer updateUserPassword(UpdateUserPasswardRequest updateUserPasswardRequest);

    Integer updateUserRole(String userrole, Integer id);
}
