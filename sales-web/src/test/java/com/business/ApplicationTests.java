package com.business;

import com.business.service.SaleInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class  ApplicationTests {
	@Resource
	private SaleInfoService saleInfoService;

	@Test
	public void contextLoads() {
	}

	@Test
	public void insert(){
		System.out.println(35>>>1);
	}


}
