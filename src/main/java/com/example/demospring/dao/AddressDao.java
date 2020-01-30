package com.example.demospring.dao;

import com.example.demospring.mapper.AddressMapper;
import com.example.demospring.pojo.Address;
import com.example.demospring.pojo.AddressExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class AddressDao {
    @Autowired
    private AddressMapper addressMapper;

    public List<Address> findAllAddress(){
        AddressExample addressExample=new AddressExample();
        return addressMapper.selectByExample(addressExample);
    }

    public Integer addAddress(Address address){
        return addressMapper.insert(address);
    }

    public Integer deleteAddress(Integer id){
        return addressMapper.deleteByPrimaryKey(id);
    }
//    public Integer updateAddress(Address address){
//        return addressMapper.updateByPrimaryKey(address);
//    }

    public Integer updateAddressByid(Address address){
        return addressMapper.updateByPrimaryKey(address);
    }

    public Integer deleteAddressByUserid(Integer userid){
        AddressExample addressExample=new AddressExample();
        addressExample.createCriteria().andUserIdEqualTo(userid);
        return addressMapper.deleteByExample(addressExample);
    }

    public List<Address> findAddressByUserid(Integer userid){
        AddressExample addressExample=new AddressExample();
        addressExample.createCriteria().andUserIdEqualTo(userid);
        return addressMapper.selectByExample(addressExample);
    }
}
