package com.example.demo.model;

import lombok.*;

@NoArgsConstructor
@EqualsAndHashCode
public class myUser {

    private static String userName;
    private static String password;
    private static String roles;

    public static String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public static String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }
}
