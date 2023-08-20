package com.alexeyleping.crm.service;

import com.alexeyleping.crm.controllers.dto.ReturnAppUserDto;
import com.alexeyleping.crm.controllers.dto.AppUserDto;
import com.alexeyleping.crm.entity.AppUser;
import com.alexeyleping.crm.repository.UserRepository;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

//implements UserDetailsService
@Service
@Transactional
public class AppUserService {

    private final UserRepository userRepository;

    public AppUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ReturnAppUserDto getUser(UUID id) {
        AppUser appUser = userRepository.findById(id).get();
        ReturnAppUserDto returnAppUserDto = new ReturnAppUserDto(appUser.getId(), appUser.getUsername(), appUser.getPassword(), appUser.getCreate(), appUser.getChange(),
                appUser.getEmail(), appUser.getAddress(), appUser.getCity(), appUser.getCountry(), appUser.getPhone(), appUser.getAppRoles());
        return returnAppUserDto;
    }

    public void createUser(AppUserDto appUserDto) {
        AppUser appUser = new AppUser(appUserDto.id(), appUserDto.username(), appUserDto.password(), appUserDto.create(), appUserDto.change(), appUserDto.email(),
                appUserDto.address(), appUserDto.city(), appUserDto.country(), appUserDto.phone(), appUserDto.appRoles());
        appUser.setCreate(LocalDate.now());
        appUser.setChange(LocalDate.now());
        userRepository.save(appUser);
    }

    public String updateUser(AppUserDto appUserDto) {
        AppUser appUser = userRepository.getReferenceById(appUserDto.id());
        if (!appUserDto.address().equals(appUser.getAddress()))
            appUser.setAddress(appUserDto.address());
        if (!appUserDto.email().equals(appUser.getEmail()))
            appUser.setEmail(appUserDto.email());
        if (!appUserDto.city().equals(appUser.getCity()))
            appUser.setCity(appUserDto.city());
        if (!appUserDto.country().equals(appUser.getCountry()))
            appUser.setCountry(appUserDto.country());
        if (!appUserDto.phone().equals(appUser.getPhone()))
            appUser.setPhone(appUserDto.phone());
        return "OK. OBJECT UPDATE.";
    }

    public void deleteUser(UUID id) {
        userRepository.deleteById(id);
    }


    public List<AppUser> getAll() {
        return userRepository.findAll();
    }

   /* @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return (UserDetails) userRepository.findByUsername(username);
    }*/
}
