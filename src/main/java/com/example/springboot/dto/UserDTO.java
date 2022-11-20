package com.example.springboot.dto;

import lombok.Data;

/**
 * 封装User
 */
@Data
public class UserDTO {
    private Long id;
    private String email;
    private String nickname;
    private String password;
    private String code;
    private String realname;
    private int age;
    private String telephone;
    private  String ident;
    private String address;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
