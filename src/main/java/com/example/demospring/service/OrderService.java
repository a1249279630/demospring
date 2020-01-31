package com.example.demospring.service;

import com.example.demospring.pojo.Orders;
import com.example.demospring.request.AddOrdersRequest;
import io.swagger.models.auth.In;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface OrderService {
    Integer addOrder(AddOrdersRequest addOrdersRequest,Integer id);
    Integer deleteOrder(Integer id);

    Integer updateOrder(Orders orders);

    List<Orders> findAllOrder(Integer PageNumber,Integer PageSize);

    Integer deleteOrdersByUserid(Integer userid);

    Orders findOrderByOrderId(Integer OrderId);

    List<Orders> findOrdersByUserId(Integer userid);

    Integer updateOrderpaystateByid(Integer id);
}
