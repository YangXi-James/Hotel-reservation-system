package com.example.springboot.mapper.Extends;

import com.example.springboot.common.domain.User;

public interface UserMapperExtends {
    User selectByEmail(String email);
    int updatePassword(User user);
    User selectByNicknameAndPassworwd(String nickname,String password);
    int updateIdentityById(Integer id);

    int updateIdentityUnblockedById(Integer id);

    int selectAll();
}
