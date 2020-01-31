package com.example.demospring.service;

import com.example.demospring.pojo.Address;
import com.example.demospring.request.AddAddressRequest;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface AddressService {
    Integer addAddress(AddAddressRequest addAddressRequest, int id);
    Integer deleteAddress(Integer id);

//    Integer updateAddress(Address address);

    List<Address> findAllAddress(Integer pageNumber, Integer pageSize);

    Integer updateAddressByid(AddAddressRequest addAddressRequest);

    Integer deleteAddressByUserid(Integer userid);

    List<Address> findAddressByUserid(Integer userid);
}
