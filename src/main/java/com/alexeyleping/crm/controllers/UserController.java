package com.alexeyleping.crm.controllers;

import com.alexeyleping.crm.controllers.dto.ReturnAppUserDto;
import com.alexeyleping.crm.controllers.dto.AppUserDto;
import com.alexeyleping.crm.entity.AppUser;
import com.alexeyleping.crm.service.AppUserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/user")
public class UserController {

    private final AppUserService appUserService;

    public UserController(AppUserService appUserService) {
        this.appUserService = appUserService;
    }

    @GetMapping("/getUserId{id}")
    public ReturnAppUserDto getUser(@PathVariable UUID id) {
        return appUserService.getUser(id);
    }

    @PostMapping("/create")
    public String createUser(@RequestBody AppUserDto appUserDto) {
        return appUserService.createUser(appUserDto);
    }

    @PutMapping
    public String updateUser(@RequestBody AppUserDto appUserDto) {
        return appUserService.updateUser(appUserDto);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable UUID id) {
        return appUserService.deleteUser(id);
    }

    @GetMapping(path = "/users")
    public List<AppUser> getAll() {
        return appUserService.getAll();
    }
}
