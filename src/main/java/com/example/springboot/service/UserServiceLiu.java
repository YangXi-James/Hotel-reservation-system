package com.example.springboot.service;

import com.example.springboot.common.domain.UserExample;
import com.example.springboot.mapper.UserMapperLiu;
import com.example.springboot.common.domain.User;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceLiu {
    @Autowired(required = false)
    private UserMapperLiu userMapperLiu;

    public PageInfo<User>  findPartUserIdentity(int pageNo,int pageSize,String idetity,User user)
    {
        PageHelper.startPage(pageNo,pageSize);
        UserExample userExample =new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria().andStatusEqualTo(idetity);
        if(user!=null)
        {
            if(user.getId()!=null)
            {
                criteria.andIdEqualTo(user.getId());
            }
            if(user.getNickname()!=null)
            {
                criteria.andNicknameLike("%"+user.getNickname()+"%");
            }
        }

        List<User> userList = userMapperLiu.selectByExample(userExample);
        PageInfo<User> pageInfo =new PageInfo<>(userList);
        System.out.println(userList);
        return pageInfo;
    }


    public int addUser(User user) {
        return userMapperLiu.insert(user);
    }

    /**
     * 删除用户
     * @param ids
     * @return
     */
    public int deleteUsersById  (Integer... ids)
    {
        int count = 0;
        if (ids != null && ids.length > 0) {
            for (Integer id : ids) {
                int i = userMapperLiu.deleteByPrimaryKey(id);
                count = count + i;
            }
        }
        return count;
    }
    public User findUserById(Integer id) {
        return userMapperLiu.selectByPrimaryKey(id);
    }
    public int updateUser(User user) {
        return userMapperLiu.updateByPrimaryKeySelective(user);
    }

    public int BlockUsersByID(Integer... ids) {
        int count = 0;
        if (ids != null && ids.length > 0) {
            for (Integer id : ids) {
                int i = userMapperLiu.updateIdentityById(id);
                count = count + i;
            }
        }
        return count;
    }

    public int unBlockUsersByID(Integer[] ids) {
        int count = 0;
        if (ids != null && ids.length > 0) {
            for (Integer id : ids) {
                int i = userMapperLiu.updateIdentityUnblockedById(id);
                count = count + i;
            }
        }
        return count;
    }

    public int getUserCount() {


        return userMapperLiu.selectAll();

    }
}
