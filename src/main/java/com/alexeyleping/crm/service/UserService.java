package com.alexeyleping.crm.service;

import com.alexeyleping.crm.controllers.dto.CustomerDto;
import com.alexeyleping.crm.controllers.dto.ReturnCustomerDto;
import com.alexeyleping.crm.controllers.dto.ReturnUserDto;
import com.alexeyleping.crm.controllers.dto.UserDto;
import com.alexeyleping.crm.entity.Customer;
import com.alexeyleping.crm.entity.User;
import com.alexeyleping.crm.repository.UserRepository;

import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

public class UserService {
    private  final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ReturnUserDto getUser(Long id){
        Optional<User> user = userRepository.findById(id);
        ReturnUserDto returnUserDto = new ReturnUserDto();
        returnUserDto.setName(user.get().getName());
        return returnUserDto;
    }

    public String createUser(UserDto userDto){
        User user = new User();
        user.setName(userDto.getName());
        user.setAddress(userDto.getAddress());
        user.setCity(userDto.getCity());
        user.setCountry(userDto.getCountry());
        user.setEmail(userDto.getEmail());
        user.setPhoneNumber(userDto.getPhoneNumber());
        Date timeStamp = Calendar.getInstance().getTime();
        user.setDateOfCreationUser(timeStamp);
        userRepository.save(user);
        return "200 OK";
    }

    public String updateUser(UserDto userDto){
        User user = userRepository.getReferenceById(userDto.getId());
        if(userDto.getName() != null)
            user.setName(userDto.getName());
        if(userDto.getDateOfChangeUser() != null)
            user.setDateOfChangeUser(userDto.getDateOfChangeUser());
        if(userDto.getDateOfCreationUser() != null)
            user.setDateOfCreationUser(userDto.getDateOfCreationUser());
        if(userDto.getAddress() != null)
            user.setAddress(userDto.getAddress());
        if(userDto.getCity() != null)
            user.setCity(userDto.getCity());
        if(userDto.getCountry() != null)
            user.setCountry(userDto.getCountry());
        if(userDto.getPhoneNumber() != null)
            user.setPhoneNumber(userDto.getPhoneNumber());
        return "OK. OBJECT UPDATE.";
    }

    public String deleteUser(Long id){
        userRepository.deleteById(id);
        return "OK. OBJECT DELETE.";
    }
}
