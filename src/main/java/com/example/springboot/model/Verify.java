package com.example.springboot.model;

import lombok.Data;

@Data
public class Verify {
    private String email;
    private int code;
}
