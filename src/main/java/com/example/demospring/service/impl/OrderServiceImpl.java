package com.example.demospring.service.impl;

import com.example.demospring.dao.OrderDao;
import com.example.demospring.pojo.Orders;
import com.example.demospring.service.OrderService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;
    @Override
    public Integer addOrder(Orders orders) {
        return orderDao.addOrders(orders);
    }

    @Override
    public Integer deleteOrder(Integer id) {
        return orderDao.deleteOrders(id);
    }

    @Override
    public Integer updateOrder(Orders orders) {
        return orderDao.updateOrders(orders);
    }

    @Override
    public List<Orders> findAllOrder(Integer PageNumber,Integer PageSize) {
        PageHelper.startPage(PageNumber,PageSize);
        List<Orders> all=orderDao.findAllOrders();
        PageInfo<Orders> pageInfo=new PageInfo<>(all);
        return pageInfo.getList();
    }

    @Override
    public Integer deleteOrdersByUserid(Integer userid) {
        return orderDao.deleteOrdersByUserid(userid);
    }

    @Override
    public Orders findOrderByOrderId(Integer orderId) {
        return orderDao.findOrderByOrderId(orderId);
    }

    @Override
    public List<Orders> findOrdersByUserId(Integer userid) {
        return orderDao.findOrdersByUserId(userid);
    }
}
