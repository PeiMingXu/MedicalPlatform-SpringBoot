package com.xmut.mapper;

import com.xmut.pojo.User;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

/**
 * @author UserMapper
 * @date: 2024/1/7 16:33
 **/
public interface UserMapper {
    //用户登陆
    @Select("select * from user where user_phone=#{phone} and user_password=#{password} and user_status='0'")
    @Results(id = "userResult",value = {
            @Result(id = true,property = "id",column = "user_id"),
            @Result(property ="name",column="user_name"),
            @Result(property ="password",column ="user_password"),
            @Result(property ="phone",column ="user_phone"),
            @Result(property ="role",column ="user_role"),
            @Result(property ="status",column ="user_status")
    })
    public User findUserByPhoneAndPassword(User user);

    //通过id查询
    @Select("select * from user where user_id=#{id}")
    @ResultMap("userResult")
    public User findById(Integer id);

}
