package com.github.ginrye.output;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.ginrye.base.exception.BusinessException;
import com.github.ginrye.base.resultstore.ResultStore;
import com.github.ginrye.model.input.DBInputService;
import com.github.ginrye.model.input.InputService;
import com.github.ginrye.model.input.query.Query;
import com.github.ginrye.model.output.FileOutputService;
import com.github.ginrye.model.output.exporter.AbstractExporter;
import com.github.ginrye.model.output.exporter.FlatXmlExporter;
import com.github.ginrye.model.output.exporter.XLSExporter;

@Test(testName = "fileOutputServiceTest")
public class FileOutputServiceTest {
	private InputService<String> inputService;
	private FileOutputService fileOutputService;
	
	@BeforeClass
	public void beforeClass() throws BusinessException {
		String dbms = "MYSQL";
		String host = "localhost";
		int port = 3306;
		String instance = "xucong_stock";
		String username = "root";
		String password = "woshixucong";
		inputService = new DBInputService(dbms, host, port, instance, username, password);
		fileOutputService = new FileOutputService("./output");
		List<AbstractExporter> exporters = new ArrayList<AbstractExporter>();
		AbstractExporter flatXmlExporter = new FlatXmlExporter();
		exporters.add(flatXmlExporter);
		AbstractExporter xlsExporter = new XLSExporter();
		exporters.add(xlsExporter);
		fileOutputService.setExporters(exporters);
	}
	
	@Test
	public void testOutput() throws BusinessException {
		Query<String> query = new Query<String>();
		query.setTableName("StockInfo");
		query.setCommand("select * from tb_stock_info_stock t");
		ResultStore store = inputService.input(query);
		fileOutputService.output(store);
		store.close();
	}
	
}
