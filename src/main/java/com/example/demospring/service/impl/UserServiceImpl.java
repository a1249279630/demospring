package com.example.demospring.service.impl;

import com.example.demospring.dao.OrderDao;
import com.example.demospring.dao.UserDao;
import com.example.demospring.pojo.Orders;
import com.example.demospring.pojo.User;
import com.example.demospring.request.RegistUserRequest;
import com.example.demospring.request.UpdateUserPasswardRequest;
import com.example.demospring.request.UpdateUserRequest;
import com.example.demospring.request.UpdateUserStateRequest;
import com.example.demospring.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private OrderDao orderDao;
    @Override
    public Integer addUser(RegistUserRequest registUserRequest) {
        List<User> userByUserName = userDao.findUserByUserName(registUserRequest.getUsername());
        if(CollectionUtils.isEmpty(userByUserName))
          {
        User user=new User();
        user.setEmail(registUserRequest.getEmail());
        user.setGender(registUserRequest.getGender());
        user.setIntroduce(registUserRequest.getIntroduce());
        user.setPassword(registUserRequest.getPassword());
        user.setTelephone(registUserRequest.getTelephone());
        user.setUsername(registUserRequest.getUsername());
        user.setActivecode(randomSafetyCode());
        user.setRegisttime(new Date());
        userDao.addUser(user);
        return 1;
        }else{
            return -1;
        }
    }

    @Override
    public Integer deleteUser(Integer id) {
        List<Orders> order = orderDao.findOrdersByUserId(id);
        if(CollectionUtils.isEmpty(order)){
            userDao.deleteUser(id);
            return 1;
        }else {
            return -1;
        }

    }

    @Override
    public Integer updateUser(UpdateUserRequest updateUserRequest, Integer id) {
        User user = userDao.findUserById(id);
        BeanUtils.copyProperties(updateUserRequest,user);
        user.setId(id);
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
    public User findUserByUserNameandPassword(String username, String password) {
        return userDao.findUserByUserNameandPassword111(username,password);
    }

    @Override
    public List<User> findUserByActiveCode(String activeCode) {
        return userDao.findUserByActiveCode(activeCode);
    }

    @Override
    public Integer updateUserPassword(UpdateUserPasswardRequest updateUserPasswardRequest) {

        List<User> users = userDao.findUserByUserName(updateUserPasswardRequest.getUsername());
        User user = new User();
        if (!CollectionUtils.isEmpty(users)){
            user = users.get(0);
        }
        if(updateUserPasswardRequest.getActivecode().equals(user.getActivecode())){
            if(updateUserPasswardRequest.getPassword().equals(user.getPassword())){
                return -1;//新密码不能与旧密码一样
            }else{
                if(updateUserPasswardRequest.getCopypassword().equals(updateUserPasswardRequest.getPassword())){
                    user.setPassword(updateUserPasswardRequest.getPassword());
                    userDao.updateUserbyUsername(user,updateUserPasswardRequest.getUsername());
                    return 1;//密码更改成功
                }else{
                    return 0;//两次密码不一致
                }
            }
        }else return -2;//安全码错误


    }

    public String randomSafetyCode(){
        char[] str = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
                'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
        int count = 0;
        int i;
        int maxNum = 62;
        StringBuffer stringBuffer = new StringBuffer();
        Random random = new Random();
        while(count < 8){
            i = Math.abs(random.nextInt(maxNum));
            if (i >= 0 && i < str.length) {
                stringBuffer.append(str[i]);
                count ++;
            }
        }
        return stringBuffer.toString();
    }
}
