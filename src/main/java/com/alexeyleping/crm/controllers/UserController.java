package com.alexeyleping.crm.controllers;

import com.alexeyleping.crm.controllers.dto.ReturnUserDto;
import com.alexeyleping.crm.controllers.dto.UserDto;
import com.alexeyleping.crm.entity.AppUser;
import com.alexeyleping.crm.entity.UserRole;
import com.alexeyleping.crm.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

  private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getUserId{id}")
    public ReturnUserDto getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }

    @PostMapping("/create")
    public String createUser (@RequestBody UserDto userDto){
        return  userService.createUser(userDto);
    }
    @PutMapping
    public String updateUser(@RequestBody UserDto userDto) {
        return userService.updateUser(userDto);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
       return userService.deleteUser(id);
    }

    @GetMapping(path = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<AppUser> getAll() {
        return userService.getAll();
    }

    @PostMapping("/role/save")
    public void saveRole(UserRole role){
        userService.saveRole(role);
    }

    @PostMapping("/role/addtouser")
    public void addRoleToUser(@RequestBody RoleToUserForm form){
        userService.addRoleToUser(form.getRoleName(), form.getLogin());
    }
}

class RoleToUserForm{
    private String login;
    private String roleName;

    public RoleToUserForm() {
    }

    public RoleToUserForm(String login, String roleName) {
        this.login = login;
        this.roleName = roleName;
    }

    public String getLogin() {
        return login;
    }

    public String getRoleName() {
        return roleName;
    }
}