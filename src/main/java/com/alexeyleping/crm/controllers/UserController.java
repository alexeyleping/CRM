package com.alexeyleping.crm.controllers;

import com.alexeyleping.crm.controllers.dto.ReturnUserDto;
import com.alexeyleping.crm.controllers.dto.UserDto;
import com.alexeyleping.crm.entity.AppUser;
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

    @PostMapping
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

}
