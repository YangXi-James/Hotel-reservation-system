package com.example.springboot.common.domain.Extends;

import com.example.springboot.common.domain.Standard;
import com.example.springboot.common.domain.User;

public class OrderExtends {
    private User user ;
    private Standard standard;

    public Standard getStandard() {
        return standard;
    }

    public void setStandard(Standard standard) {
        this.standard = standard;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
