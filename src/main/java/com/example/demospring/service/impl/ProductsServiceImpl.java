package com.example.demospring.service.impl;

import com.example.demospring.dao.ProductDao;
import com.example.demospring.pojo.Products;
import com.example.demospring.service.ProductsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductsServiceImpl implements ProductsService {
    @Autowired
    private ProductDao productDao;
    @Override
    public Integer addProducts(Products products) {
        return productDao.addProducts(products);
    }

    @Override
    public Integer deleteProducts(Integer id) {
        return productDao.deleteProducts(id);
    }

    @Override
    public Integer updateProducts(Products products) {
        return productDao.updateProducts(products);
    }

    @Override
    public List<Products> findAllProducts(Integer pageNumber,Integer pageSize) {
        PageHelper.startPage(pageNumber,pageSize);
        List<Products> all=productDao.findAllProducts();
        PageInfo<Products> pageInfo=new PageInfo<>(all);
        return pageInfo.getList();

    }

    @Override
    public Integer updatePNum(int num, Integer id) {
        return productDao.updatePNum(num,id);
    }

    @Override
    public long count(String category) {
        return productDao.count(category);
    }

    @Override
    public Products findBookById(Integer id) {
        return productDao.findBookById(id);
    }
}
