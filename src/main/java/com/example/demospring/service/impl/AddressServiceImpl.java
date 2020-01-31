package com.example.demospring.service.impl;

import com.example.demospring.dao.AddressDao;
import com.example.demospring.pojo.Address;
import com.example.demospring.request.AddAddressRequest;
import com.example.demospring.service.AddressService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressDao addressDao;
    @Override
    public Integer addAddress(AddAddressRequest adr, int id) {
        Address address=new Address();
        address.setReceiveaddress(adr.getReceiveaddress());
        address.setReceivename(adr.getReceivename());
        address.setReceivephone(adr.getReceivename());
        address.setUserId(id);
        return addressDao.addAddress(address);
    }

    @Override
    public Integer deleteAddress(Integer id) {
        return addressDao.deleteAddress(id);
    }

//    @Override
////    public Integer updateAddress(Address address) {
////        return addressDao.updateAddress(address);
////    }

    @Override
    public List<Address> findAllAddress(Integer pageNumber, Integer pageSize) {
        PageHelper.startPage(pageNumber,pageSize);
        List<Address> all=addressDao.findAllAddress();
        PageInfo<Address> pageInfo=new PageInfo<>(all);
        return pageInfo.getList();
    }

    @Override
    public Integer updateAddressByid(AddAddressRequest adr) {
        Address address=new Address();
        address.setReceiveaddress(adr.getReceiveaddress());
        address.setReceivename(adr.getReceivename());
        address.setReceivephone(adr.getReceivename());
        return addressDao.updateAddressByid(address);
    }

    @Override
    public Integer deleteAddressByUserid(Integer userid) {
        return addressDao.deleteAddressByUserid(userid);
    }

    @Override
    public List<Address> findAddressByUserid(Integer userid) {
        return addressDao.findAddressByUserid(userid);
    }
}
