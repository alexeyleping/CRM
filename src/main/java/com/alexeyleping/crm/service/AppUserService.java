package com.alexeyleping.crm.service;

import com.alexeyleping.crm.controllers.dto.ReturnUserDto;
import com.alexeyleping.crm.controllers.dto.UserDto;
import com.alexeyleping.crm.entity.AppUser;
import com.alexeyleping.crm.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class AppUserService implements UserDetailsService {
    private  final UserRepository userRepository;

    public AppUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ReturnUserDto getUser(UUID id){
        Optional<AppUser> appUser = userRepository.findById(id);
        ReturnUserDto returnUserDto = new ReturnUserDto(
                appUser.get().getId(),
                appUser.get().getUsername(),
                appUser.get().getCreate(),
                appUser.get().getChange(),
                appUser.get().getEmail(),
                appUser.get().getAddress(),
                appUser.get().getCity(),
                appUser.get().getCountry(),
                appUser.get().getPhone());
        return returnUserDto;
    }

    public String createUser(UserDto userDto){
        AppUser appUser = new AppUser();
        userRepository.save(appUser);
        return "200 OK";
    }

    public String updateUser(UserDto userDto){
        AppUser appUser = userRepository.getReferenceById(userDto.id());
        return "OK. OBJECT UPDATE.";
    }

    public String deleteUser(UUID id){
        userRepository.deleteById(id);
        return "OK. OBJECT DELETE.";
    }


    public Page<AppUser> getAll(Integer limit, Integer page) {
        return  userRepository.findAll(PageRequest.of(page, limit));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return (UserDetails) userRepository.findByUsername(username);
    }
}
