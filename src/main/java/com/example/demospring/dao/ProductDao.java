package com.example.demospring.dao;

import com.example.demospring.mapper.ProductsMapper;
import com.example.demospring.pojo.Products;
import com.example.demospring.pojo.ProductsExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDao {
    @Autowired
    private ProductsMapper productsMapper;

    public List<Products> findAllProducts(){
        ProductsExample productsExample=new ProductsExample();
        return productsMapper.selectByExample(productsExample);
    }

    public Integer addProducts(Products products){
        return productsMapper.insert(products);
    }

    public Integer deleteProducts(Integer id){
        return productsMapper.deleteByPrimaryKey(id);
    }
    public Integer updateProducts(Products products){
        return productsMapper.updateByPrimaryKey(products);
    }

    public Products findBookById(Integer id)  {
        Products products = productsMapper.selectByPrimaryKey(id);
        if(products.toString().isEmpty()){
            return null;
        }return products;

    }

    //category 如果是null，是表的所所有记录数
    public long count(String category)   {
        ProductsExample productsExample=new ProductsExample();
        return productsMapper.countByExample(productsExample);
    }

    public Integer updatePNum(int num,Integer id) {

        Products products = productsMapper.selectByPrimaryKey(id);
        if(products.getPnum()>num&&products.getPnum()>0){
            products.setPnum(products.getPnum()-num);
        }else{
            new Exception("数量不够");
        }
        return productsMapper.updateByPrimaryKey(products);
    }

    public List<Products> findBookByName(String bookname) {
        ProductsExample productsExample=new ProductsExample();
        productsExample.createCriteria().andNameLike("%"+bookname+"%");
        return productsMapper.selectByExample(productsExample);
    }
}
