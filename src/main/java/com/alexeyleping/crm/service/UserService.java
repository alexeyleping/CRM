package com.alexeyleping.crm.service;

import com.alexeyleping.crm.controllers.dto.ReturnUserDto;
import com.alexeyleping.crm.controllers.dto.UserDto;
import com.alexeyleping.crm.entity.AppUser;
import com.alexeyleping.crm.entity.UserRole;
import com.alexeyleping.crm.repository.UserRepository;
import com.alexeyleping.crm.repository.UserRoleRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service @Transactional
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository ;

    public UserService(UserRepository userRepository, UserRoleRepository  userRoleRepository ) {
        this.userRepository = userRepository;
        this.userRoleRepository  = userRoleRepository;
    }

    public ReturnUserDto getUser(Long id){
        Optional<AppUser> user = userRepository.findById(id);
        ReturnUserDto returnUserDto = new ReturnUserDto();
        returnUserDto.setName(user.get().getName());
        return returnUserDto;
    }

    public String createUser(UserDto userDto){
        AppUser appUser = new AppUser();
        appUser.setName(userDto.getName());
        appUser.setAddress(userDto.getAddress());
        appUser.setCity(userDto.getCity());
        appUser.setCountry(userDto.getCountry());
        appUser.setEmail(userDto.getEmail());
        appUser.setPhoneNumber(userDto.getPhoneNumber());
        Date timeStamp = Calendar.getInstance().getTime();
        appUser.setDateOfCreationUser(timeStamp);
        userRepository.save(appUser);
        return "200 OK";
    }

    public String updateUser(UserDto userDto){
        AppUser appUser = userRepository.getReferenceById(userDto.getId());
        if(userDto.getName() != null)
            appUser.setName(userDto.getName());
        if(userDto.getDateOfChangeUser() != null)
            appUser.setDateOfChangeUser(userDto.getDateOfChangeUser());
        if(userDto.getDateOfCreationUser() != null)
            appUser.setDateOfCreationUser(userDto.getDateOfCreationUser());
        if(userDto.getAddress() != null)
            appUser.setAddress(userDto.getAddress());
        if(userDto.getCity() != null)
            appUser.setCity(userDto.getCity());
        if(userDto.getCountry() != null)
            appUser.setCountry(userDto.getCountry());
        if(userDto.getPhoneNumber() != null)
            appUser.setPhoneNumber(userDto.getPhoneNumber());
        return "OK. OBJECT UPDATE.";
    }

    public String deleteUser(Long id){
        userRepository.deleteById(id);
        return "OK. OBJECT DELETE.";
    }

    public void addRoleToUser(String login, String roleName){
        AppUser appUser = userRepository.findByLogin(login);
        UserRole userRole = userRoleRepository.findByRole(roleName);
        appUser.getRoles().add(userRole);
    }

    public void saveRole(UserRole userRole){
        userRoleRepository.save(userRole);
    }

    public List<AppUser> getAll() {
        return userRepository.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = userRepository.findByLogin(username);
        if (username == null){
            throw new UsernameNotFoundException("Not found username!");
        }
        Collection<SimpleGrantedAuthority>authorities=new ArrayList<>();
        appUser.getRoles().forEach(userRole ->
         authorities.add(new SimpleGrantedAuthority(userRole.getRole())));
        return new org.springframework.security.core.userdetails.User(appUser.getLogin(), appUser.getPassword(), authorities);
    }
}
