package com.alexeyleping.crm.controllers;

import com.alexeyleping.crm.entity.AppUser;
import com.alexeyleping.crm.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(path = "/login")
    public @ResponseBody AppUser getAuthUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Object principal = auth.getPrincipal();
        AppUser appUser = (AppUser) principal;
        return Objects.nonNull(appUser) ? userService.getByLogin(appUser.getLogin()) : null;
    }


}
