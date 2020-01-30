package com.example.demospring.controller;

import com.example.demospring.pojo.Address;
import com.example.demospring.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Component;
import java.util.List;

@RestController
public class AddressController {
    @Autowired
private AddressService addressService;
    @PostMapping(value = "find/allAddress")
    public List<Address> findAllAddress(@RequestBody Integer pageNumber, Integer pageSize){
        return addressService.findAllAddress(pageNumber,pageSize);
    }

//    @PostMapping(value = "add/address")
//    public Integer addAddress(@RequestBody Address address){
//        return addressService.addAddress(address);
//    }


    @PostMapping(value = "add/Address/by/json")
    public Integer addAddressByJson(@RequestBody Address address){
        return addressService.addAddress(address);
    }
//
//
    @DeleteMapping(value = "delete/address/by/id")
    public Integer deleteAddress(@RequestBody Integer id) {
        return addressService.deleteAddress(id);
    }

    @PostMapping(value = "update/address/by/id")
    public Integer updateAddressByid(Address address) {
        return addressService.updateAddressByid(address);
    }

    @DeleteMapping(value = "delete/address/by/userid")
    public Integer deleteAddressByUserid(Integer userid) {
        return addressService.deleteAddressByUserid(userid);
    }

    @GetMapping(value = "find/address/by/userid")
    public List<Address> findAddressByUserid(Integer userid) {
        return addressService.findAddressByUserid(userid);
    }
}





