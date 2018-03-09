package com.yajima.miaosha.dao;

import com.yajima.miaosha.model.MiaoshaUser;
import com.yajima.miaosha.model.MiaoshaUserExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface MiaoshaUserMapper {
    int countByExample(MiaoshaUserExample example);

    int deleteByExample(MiaoshaUserExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MiaoshaUser record);

    int insertSelective(MiaoshaUser record);

    List<MiaoshaUser> selectByExample(MiaoshaUserExample example);

    MiaoshaUser selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MiaoshaUser record, @Param("example") MiaoshaUserExample example);

    int updateByExample(@Param("record") MiaoshaUser record, @Param("example") MiaoshaUserExample example);

    int updateByPrimaryKeySelective(MiaoshaUser record);

    int updateByPrimaryKey(MiaoshaUser record);
}