package com.example.demospring.controller;

import com.example.demospring.pojo.Orders;
import com.example.demospring.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;
    @GetMapping(value = "find/all/order")
    public List<Orders> findAllOrders(Integer PageNumber,Integer PageSize){
        return orderService.findAllOrder(PageNumber,PageSize);
    }

    @PostMapping(value = "add/orders")
    public Integer addOrders(@RequestBody Orders orders){
        return orderService.addOrder(orders);
    }



    @DeleteMapping(value = "delete/orders/by/id")
    public Integer deleteOrders(@RequestBody Integer id) {
        return orderService.deleteOrder(id);
    }

    @PostMapping(value = "update/order/by/order")
    public Integer updateOrders(@RequestBody Orders orders) {
        return orderService.updateOrder(orders);
    }

    @DeleteMapping(value = "delete/order/by/userid")
    public Integer deleteOrdersByUserid(Integer userid) {
        return orderService.deleteOrdersByUserid(userid);
    }

    @GetMapping(value = "find/orders/by/Orderid")
    public Orders findOrderByOrderId(Integer orderId) {
        return orderService.findOrderByOrderId(orderId);
    }

    @GetMapping(value = "find/order/by/Userid")
    public List<Orders> findOrdersByUserId(Integer userid){
        return orderService.findOrdersByUserId(userid);
    }
}
