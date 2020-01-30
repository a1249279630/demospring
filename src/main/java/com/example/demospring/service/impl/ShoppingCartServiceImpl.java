package com.example.demospring.service.impl;

import com.example.demospring.dao.ShoppingCartDao;
import com.example.demospring.pojo.ShoppingCart;
import com.example.demospring.service.ShoppingCartService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    @Autowired
    private ShoppingCartDao shoppingCartDao;
    @Override
    public Integer addShoppingCart(ShoppingCart shoppingCart) {
        return shoppingCartDao.addShoppingCart(shoppingCart);
    }

    @Override
    public Integer deleteShoppingCart(Integer id) {
        return shoppingCartDao.deleteShoppingCart(id);
    }

    @Override
    public Integer updateShoppingCart(ShoppingCart user) {
        return shoppingCartDao.updateShoppingCart(user);
    }

    @Override
    public List<ShoppingCart> findAllShoppingCart(Integer pageNumber, Integer pageSize) {
        PageHelper.startPage(pageNumber,pageSize);
        List<ShoppingCart> all=shoppingCartDao.findAllShoppingCart();
        PageInfo<ShoppingCart> pageInfo=new PageInfo<>(all);
        return pageInfo.getList();

    }

    @Override
    public ShoppingCart findshopByid(Integer id) {
        return shoppingCartDao.findshopByid(id);
    }

    @Override
    public List<ShoppingCart> findshopByUserid(Integer userid) {
        return shoppingCartDao.findshopByUserid(userid);
    }

    @Override
    public Integer deleteShopByUserid(Integer userid) {
        return shoppingCartDao.deleteShopByUserid(userid);
    }

    @Override
    public Integer updateReducePNum(int num, Integer id) {
        return shoppingCartDao.updateReducePNum(num,id);
    }

    @Override
    public Integer updatAddPNum(int num, Integer id) {
        return shoppingCartDao.updatAddPNum(num, id);
    }
}
