package com.example.demo.controller;

import com.example.demo.model.myUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private JdbcUserDetailsManager jdbcUserDetailsManager;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @PostMapping(value = "/register-user")
    public String regiter (@RequestBody myUser myuser){
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(myuser.getRoles()));
        String encodededPassword = passwordEncoder.encode(myuser.getPassword());
        User user1 = new User(myuser.getUserName(),encodededPassword,authorities);
        jdbcUserDetailsManager.createUser(user1);
        return "User created :)";
    }

    @GetMapping(value = "/admin")
    public String admin(){
        return "<h3>Welcome Admin :)</h3>";
    }

    @GetMapping(value = "/user")
    public String user(){
        return "<h3>Hello user :)</h3>";
    }

    @GetMapping(value = "/")
    public String welcome(){
        return "<h3>Welcome  :)</h3>";
    }
}
