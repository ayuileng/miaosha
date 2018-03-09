package com.yajima.miaosha;

import com.yajima.miaosha.dao.MiaoshaUserMapper;
import com.yajima.miaosha.service.MiaoshaUserService;
import com.yajima.miaosha.vo.LoginVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MiaoshaApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Autowired
	MiaoshaUserMapper userMapper;
	@Autowired
	MiaoshaUserService miaoshaUserService;
	@Test
	public void test(){
		System.out.println(userMapper.selectByPrimaryKey(18662633693l));
	}


}
