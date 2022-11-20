package com.example.springboot.controller;

import com.example.springboot.common.domain.User;
import com.example.springboot.common.utils.Result;
import com.example.springboot.service.UserServiceLiu;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserControllerLiu {
    @Autowired
    UserServiceLiu userServiceLiu;

    /*
    * 分页查询猎豹接口
     */
    @RequestMapping("/userList")
    @ResponseBody //加上这个才是会默认返回数据
    public Object getUserList(User user,@RequestParam(defaultValue="1") int pageNo,@RequestParam(defaultValue="10")  int pageSize)
    {
        PageInfo<User> userPageInfo= userServiceLiu.findPartUserIdentity(pageNo,pageSize,"用户",user);
        return Result.success(userPageInfo);
    }

    @RequestMapping("/adminList")
    @ResponseBody //加上这个才是会默认返回数据
    public Object getAdminList(User user,@RequestParam(defaultValue="1") int pageNo,@RequestParam(defaultValue="10")  int pageSize)
    {
        PageInfo<User> userPageInfo= userServiceLiu.findPartUserIdentity(pageNo,pageSize,"管理员",user);
        return Result.success(userPageInfo);
    }

    @RequestMapping("/blockedUserList")
    @ResponseBody //加上这个才是会默认返回数据
    public Object getBlockedUserList(User user,@RequestParam(defaultValue="1") int pageNo,@RequestParam(defaultValue="10")  int pageSize)
    {
        PageInfo<User> userPageInfo= userServiceLiu.findPartUserIdentity(pageNo,pageSize,"冻结中",user);
        return Result.success(userPageInfo);
    }

    @RequestMapping("/deleteUser")
    @ResponseBody
    public Object deleteUsers(@RequestBody Integer[] ids)
    {
        int count= userServiceLiu.deleteUsersById(ids);
        return Result.success(count,"操作成功",200);
    }
    @RequestMapping("/blockUsers")
    @ResponseBody
    public Object blockUsers(@RequestBody Integer[] ids)
    {
        int count= userServiceLiu.BlockUsersByID(ids);
        return Result.success(count,"操作成功",200);
    }
    @GetMapping("/getUserCount")
    @ResponseBody
    public Integer getUserCount()
    {
        int count= userServiceLiu.getUserCount();
     /*   return Result.success(count,"操作成功",200);*/
        return count;
    }

    @RequestMapping("/unblockUsers")
    @ResponseBody
    public Object unblockUsers(@RequestBody Integer[] ids)
    {
        int count= userServiceLiu.unBlockUsersByID(ids);
        return Result.success(count,"操作成功",200);
    }
    @RequestMapping("/addAdmin")
    @ResponseBody
    public Object addUser(@RequestBody User user){
        user.setStatus("管理员");
        System.out.println(user);
        int count = userServiceLiu.addUser(user);
        return Result.success(count,"操作成功",200);
    }
    @RequestMapping("/showUser")
    public String showUser(ModelMap modelMap, Integer id){
        User user = userServiceLiu.findUserById(id);
        modelMap.put("user",user);
        return "/views/showUserDetial";
    }

    @RequestMapping("/updateUserQuest")
    public String updateUser(ModelMap modelMap,Integer id){
        User user = userServiceLiu.findUserById(id);
        modelMap.put("user",user);
        return "views/updateUser";
    }
    /**
     *
     */
    @RequestMapping("/subminUpdatedUser")
    @ResponseBody
    public Object showUpdateUser(@RequestBody User user){
        int count = userServiceLiu.updateUser(user);
        return Result.success(count,"操作成功",200);
    }
}
