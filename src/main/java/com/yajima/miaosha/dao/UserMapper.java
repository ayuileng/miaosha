package com.yajima.miaosha.dao;

import com.yajima.miaosha.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

/**
 * Created by xu on 2018/1/17.
 */
@Mapper
@Component
public interface UserMapper {
    @Insert("insert into user(id,name) values (#{id},#{name})")
    public int insert(User user);

    @Select("select * from user where id = #{id}")
    public User getUserById(@Param("id")Long id);
}
