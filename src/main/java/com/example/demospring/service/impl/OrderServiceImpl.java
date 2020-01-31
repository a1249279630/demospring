package com.example.demospring.service.impl;

import com.example.demospring.dao.OrderDao;
import com.example.demospring.dao.ProductDao;
import com.example.demospring.pojo.Orders;
import com.example.demospring.pojo.Products;
import com.example.demospring.request.AddOrdersRequest;
import com.example.demospring.service.OrderService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private static ProductDao productDao;

    @Override
    public Integer addOrder(AddOrdersRequest aor,Integer id) {

        try {
            Products products = productDao.findBookById(aor.getProductId());
            Orders orders=new Orders();
            orders.setUserId(id);
            orders.setNum(aor.getNum());
            orders.setProductId(aor.getProductId());
            orders.setOrdertime(new Date());
            orders.setPaystate(0);
            orders.setMoney(products.getPrice()*aor.getNum());
            orderDao.addOrders(orders);
            return 1;
        }catch (Exception e){
            return -1;
        }

    }

    @Override
    public Integer deleteOrder(Integer id) {
        try{
            Orders orderByOrderId = orderDao.findOrderByOrderId(id);
            if(orderByOrderId.getPaystate()==0){
                orderDao.deleteOrders(id);
                return 1;
            }else{
                return -1;
            }
        }catch (Exception e){
            return -2;
        }

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

        List<Orders> ordersByUserId = orderDao.findOrdersByUserId(userid);
        int notPay=0;
        for(Orders orders:ordersByUserId){
            if(orders.getPaystate()==0){
                orderDao.deleteOrdersByUserid(userid);
                notPay++;
            }
        }
        return notPay;
    }

    @Override
    public Orders findOrderByOrderId(Integer orderId) {
        return orderDao.findOrderByOrderId(orderId);
    }

    @Override
    public List<Orders> findOrdersByUserId(Integer userid) {
        return orderDao.findOrdersByUserId(userid);
    }

    @Override
    public Integer updateOrderpaystateByid(Integer id) {
        Orders order = orderDao.findOrderByOrderId(id);
        order.setPaystate(1);
        return orderDao.updateOrders(order);
    }
}
