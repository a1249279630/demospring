package com.example.demospring.service;

import com.example.demospring.pojo.ShoppingCart;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ShoppingCartService {
    Integer addShoppingCart(ShoppingCart shoppingCart);
    Integer deleteShoppingCart(Integer id);

    Integer updateShoppingCart(ShoppingCart user);

    List<ShoppingCart> findAllShoppingCart(Integer pageNumber, Integer pageSize);

    ShoppingCart findshopByid(Integer id);

    List<ShoppingCart> findshopByUserid(Integer userid);

    Integer deleteShopByUserid(Integer userid);

    /*通过id减少购物车产品的数量*/
    Integer updateReducePNum(int num,Integer id);

    /*通过id增加购物车产品的数量*/
    Integer updatAddPNum(int num,Integer id) ;

}
