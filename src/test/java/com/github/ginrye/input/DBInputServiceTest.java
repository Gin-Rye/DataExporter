package com.github.ginrye.input;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.ginrye.base.exception.BusinessException;
import com.github.ginrye.base.resultstore.ResultStore;
import com.github.ginrye.model.input.DBInputService;
import com.github.ginrye.model.input.query.Query;

@Test(testName = "dbInputServiceTest")
public class DBInputServiceTest {
	private DBInputService dbInputService;
	
	@BeforeClass
	public void beforeClass() throws BusinessException {
		String dbms = "MYSQL";
		String host = "localhost";
		int port = 3306;
		String instance = "xucong_stock";
		String username = "root";
		String password = "woshixucong";
		dbInputService = new DBInputService(dbms, host, port, instance, username, password);
	}
	
	@Test
	public void testInput1() throws BusinessException {
		Query<String> query = new Query<String>();
		query.setTableName("StockInfo");
		query.setCommand("select * from tb_stock_info_stock t");
		ResultStore store = dbInputService.input(query);
		int size = store.getSize();
		store.close();
		Assert.assertTrue(size == 944);
	}
}
