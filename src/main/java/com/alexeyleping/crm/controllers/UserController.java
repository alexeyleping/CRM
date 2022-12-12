package com.alexeyleping.crm.controllers;

import com.alexeyleping.crm.controllers.dto.ReturnUserDto;
import com.alexeyleping.crm.controllers.dto.UserDto;
import com.alexeyleping.crm.entity.AppUser;
import com.alexeyleping.crm.entity.Role;
import com.alexeyleping.crm.service.UserService;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

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
    public @ResponseBody ReturnUserDto getAll() {
        return userService.getAll();
    }

    /*@PostMapping("/role/save")
    public void saveRole(Role role){
        userService.saveRole(role);
    }
    */
    @GetMapping("/token/refresh")
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String authorizationHeader = request.getHeader(AUTHORIZATION);
        if(authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            try {
                String refreshToken = authorizationHeader.substring("Bearer ".length());
                Algorithm algorithm = Algorithm.HMAC256("secret".getBytes(StandardCharsets.UTF_8));
                JWTVerifier jwtVerifier = JWT.require(algorithm).build();
                DecodedJWT decodedJWT = jwtVerifier.verify(refreshToken);
                String login = decodedJWT.getSubject();
                AppUser appUser = userService.getByLogin(login);

                String accessToken = JWT.create()
                        .withSubject(appUser.getLogin())
                        .withExpiresAt(new Date(System.currentTimeMillis() + 10 * 60 * 1000))
                        .withIssuer(request.getRequestURL().toString())
                        .withClaim("roles", appUser.getRoles().stream().map(Role::getRole).collect(Collectors.toList()))
                        .sign(algorithm);
            } catch (Exception e) {
                response.setHeader("error", e.getMessage());
                response.setStatus(FORBIDDEN.value());
                //response.sendError(FORBIDDEN.value());
                Map<String, String> error = new HashMap<>();
                error.put("error_message", e.getMessage());
                response.setContentType(APPLICATION_JSON_VALUE);
                new ObjectMapper().writeValue(response.getOutputStream(), error);
            }
        }else {
                throw new RuntimeException("refresh token is missing");
            }
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