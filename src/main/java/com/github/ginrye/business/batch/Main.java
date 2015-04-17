package com.github.ginrye.business.batch;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.github.ginrye.base.log.Logger;
import com.github.ginrye.business.io.IOWorker;
import com.github.ginrye.model.input.DBInputService;
import com.github.ginrye.model.input.InputService;
import com.github.ginrye.model.input.query.Query;
import com.github.ginrye.model.output.FileOutputService;
import com.github.ginrye.model.output.OutputService;
import com.github.ginrye.model.output.exporter.AbstractExporter;
import com.github.ginrye.model.output.exporter.FlatXmlExporter;
import com.github.ginrye.model.output.exporter.XLSExporter;

public class Main {
	public final static String BATCH_FILE = "./conf/batch.xml";
	
	public final static String DBMS = "MYSQL";
	public final static String HOST = "localhost";
	public final static int PORT = 3306;
	public final static String INSTANCE = "xucong_stock";
	public final static String USERNAME = "root";
	public final static String PASSWORD = "woshixucong";
	
	public final static String DIRECTORY_PATH = "./output";
	
	public static void main(String[] args) {
		try {
			List<IOWorker<String>> workers = new ArrayList<IOWorker<String>>();
			InputService<String> inputService = 
					new DBInputService(DBMS, HOST, PORT, INSTANCE, USERNAME, PASSWORD);
			OutputService outputService =
					new FileOutputService(DIRECTORY_PATH);
			AbstractExporter flatXmlExporter = new FlatXmlExporter();
			AbstractExporter xlsExporter = new XLSExporter();
			List<AbstractExporter> exporters = new ArrayList<AbstractExporter>();
			exporters.add(flatXmlExporter);
			exporters.add(xlsExporter);
			((FileOutputService) outputService).setExporters(exporters);
			SAXReader reader = new SAXReader();
			Document document = reader.read(BATCH_FILE);
			Element root = document.getRootElement();
			Iterator<?> iterator = root.elementIterator();
			while(iterator.hasNext()) {
				Element element = (Element) iterator.next();
				List<Element> queryElements = element.elements();
				for(Element queryElement : queryElements) {
					String tableName = queryElement.elementText("tableName");
					String command = queryElement.elementText("command");
					Query<String> query = new Query<String>();
					query.setTableName(tableName);
					query.setCommand(command);
					IOWorker<String> worker = new IOWorker<String>();
					worker.setInputService(inputService);
					worker.setOutputService(outputService);
					worker.setQuery(query);
					workers.add(worker);
					Thread thread = new Thread(worker);
					thread.start();
				}
			}
		} catch(Exception e) {
			Logger.error(e);
		}
	}
}
