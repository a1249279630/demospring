package com.example.demospring.service.impl;

import com.example.demospring.dao.ProductDao;
import com.example.demospring.pojo.Products;
import com.example.demospring.request.AddProductsRequest;
import com.example.demospring.request.UpdateProductsRequest;
import com.example.demospring.response.FindProductResponse;
import com.example.demospring.service.ProductsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Service
public class ProductsServiceImpl implements ProductsService {
    @Autowired
    private ProductDao productDao;
    @Override
    public Integer addProducts(AddProductsRequest apr) {
        Products products=new Products();
        products.setCategory(apr.getCategory());
        products.setPnum(apr.getPnum());
        products.setDescription(apr.getDescription());
        products.setImgurl(apr.getImgurl());
        products.setName(apr.getName());
        products.setPrice(apr.getPrice());
        products.setCreattime(new Date());
        return productDao.addProducts(products);
    }

    @Override
    public Integer deleteProducts(Integer id) {
        return productDao.deleteProducts(id);
    }

    @Override
    public Integer updateProducts(UpdateProductsRequest upr, Integer id) {
        Products products = productDao.findBookById(id);
        products.setCategory(upr.getCategory());
        products.setPnum(upr.getPnum());
        products.setDescription(upr.getDescription());
        products.setImgurl(upr.getImgurl());
        products.setName(upr.getName());
        products.setPrice(upr.getPrice());
        products.setCreattime(new Date());
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

    @Override
    public List<FindProductResponse> findProductByBookName(Integer pageNum,Integer pageSize,String bookName) {

        PageHelper.startPage(pageNum,pageSize);
        List<Products> all = productDao.findBookByName(bookName);
        PageInfo<Products> pageInfo=new PageInfo<>(all);
        List<Products> products = pageInfo.getList();
        return ShowFindProductResponse(products);
    }

    private List<FindProductResponse> ShowFindProductResponse(List<Products> products) {
        List<FindProductResponse> productResponseList=new ArrayList<>();
        for(Products product:products){
            FindProductResponse findProductResponse=new FindProductResponse();
            BeanUtils.copyProperties(product,findProductResponse);
            productResponseList.add(findProductResponse);
        }
        return productResponseList;
    }

}
