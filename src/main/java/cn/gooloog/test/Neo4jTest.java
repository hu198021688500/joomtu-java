package cn.gooloog.test;

import javax.annotation.Resource;

import org.junit.Test;

import cn.gooloog.service.UserService;

public class Neo4jTest {
	@Resource
	private UserService userService;

	@Test
	public void test() {
		userService.find(1).getUid().equals(new Long(1));
		// fail("Not yet implemented");
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

}
