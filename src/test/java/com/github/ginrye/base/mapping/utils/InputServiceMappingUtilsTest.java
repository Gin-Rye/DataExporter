package com.github.ginrye.base.mapping.utils;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.ginrye.base.exception.BusinessException;

@Test(testName = "inputServiceMappingUtilsTest")
public class InputServiceMappingUtilsTest {
	
	@Test
	public void testGetClassName() throws BusinessException {
		//input: type = DB
		//output: com.github.ginrye.input.DBInputService
		String type = "DB";
		String className = InputServiceMappingUtils.getInstance().getClassName(type);
		Assert.assertTrue("com.github.ginrye.input.DBInputService".equals(className));
	}
}
