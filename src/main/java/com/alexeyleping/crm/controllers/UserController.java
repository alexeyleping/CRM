package com.alexeyleping.crm.controllers;

import com.alexeyleping.crm.controllers.dto.ReturnUserDto;
import com.alexeyleping.crm.controllers.dto.UserDto;
import com.alexeyleping.crm.entity.AppUser;
import com.alexeyleping.crm.service.AppUserService;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@RestController
@RequestMapping("/user")
public class UserController {

    private final AppUserService appUserService;

    public UserController(AppUserService appUserService) {
        this.appUserService = appUserService;
    }

    @GetMapping("/getUserId{id}")
    public ReturnUserDto getUser(@PathVariable UUID id) {
        return appUserService.getUser(id);
    }

    @PostMapping("/create")
    public String createUser(@RequestBody UserDto userDto) {
        return appUserService.createUser(userDto);
    }

    @PutMapping
    public String updateUser(@RequestBody UserDto userDto) {
        return appUserService.updateUser(userDto);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable UUID id) {
        return appUserService.deleteUser(id);
    }

    @GetMapping(path = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
    public Page<AppUser> getAll(@RequestParam(value = "limit", defaultValue = "10") Integer limit,
                                @RequestParam(value = "page", defaultValue = "0") Integer page) {
        return appUserService.getAll(limit, page);
    }
}
