package com.github.ginrye.base.mapping.utils;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.ginrye.base.exception.BusinessException;
import com.github.ginrye.base.mapping.utils.DbmsMappingUtils;

@Test(testName = "dbmsMappingUtilsTest")
public class DbmsMappingUtilsTest {
	
	@Test
	public void testGetDriverClassName1() throws BusinessException {
		//input: type = MYSQL
		//output: com.mysql.jdbc.Driver
		String type = "MYSQL";
		String driverClassName = DbmsMappingUtils.getInstance().getDriverClassName(type);
		Assert.assertTrue("com.mysql.jdbc.Driver".equals(driverClassName));
	}
	
	@Test
	public void testGetConnectionUrl1() throws BusinessException {
		//input: type = MYSQL, host = localhost, port = 3306, instance = test
		//output: com.mysql.jdbc.Driver
		String type = "MYSQL";
		String host = "localhost";
		int port = 3306;
		String instance = "test";
		String connectionUrl = DbmsMappingUtils.getInstance().getConnectionUrl(type, host, port, instance);
		Assert.assertTrue("jdbc:mysql://localhost:3306/test".equals(connectionUrl));
	}
}
