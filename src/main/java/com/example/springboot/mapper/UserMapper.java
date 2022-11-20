package com.example.springboot.mapper;

import com.example.springboot.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

/**
 *
 */
@Repository
@Mapper
public interface UserMapper {

    /**
     * 插入用户表
     * @param user 用户，带有email、nickname、password参数
     * @return
     */
    @Insert("insert into user(email,nickname,password) values(#{email},#{nickname},#{password})")
    int insert(User user);

    /**
     * 更新用户表
     * @param user 用户，带有email、nickname、password参数
     * @return
     */

    @Update("update  user set password = #{password} where email = #{email}")
    int update(User user);

    /**
     * 使用id查找用户
     * @param id 用户id
     * @return
     */
    @Select("select * from user where id = #{id}")
    User selectById(Long id);

    /**
     * 使用昵称和密码查找用户
     * @param nickname  昵称
     * @param password  密码
     * @return
     */
    @Select("select * from user where nickname = #{nickname} and password = #{password} ")
    User selectByNicknamePwd(String nickname, String password);

    /**
     * 使用邮箱号查找用户
     * @param email 邮箱号
     * @return
     */
    @Select("select * from user where email = #{email}")
    User selectByEmail(String email);

    /**
     * 使更新用户所有信息
     *@param
     * @return
     */
    @Update("update  user set nickname = #{nickname} , email = #{email}  " +
            ", realname = #{realname} , age = #{age} , telephone = #{telephone} " +
            ", ident = #{ident} , address = #{address} where id=#{id}")
    int updateall(User user);

    /**
     * 使更新用户所有信息
     *@param
     * @return
     */
    @Select("select * from user where id=#{id}" )
    User getdataall(int id);
}
