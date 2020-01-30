package com.example.demospring.service;

import com.example.demospring.pojo.Address;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface AddressService {
    Integer addAddress(Address address);
    Integer deleteAddress(Integer id);

//    Integer updateAddress(Address address);

    List<Address> findAllAddress(Integer pageNumber, Integer pageSize);

    Integer updateAddressByid(Address address);

    Integer deleteAddressByUserid(Integer userid);

    List<Address> findAddressByUserid(Integer userid);
}
