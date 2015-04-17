package com.github.ginrye.model.output;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.github.ginrye.base.exception.BusinessException;
import com.github.ginrye.base.resultstore.ResultStore;
import com.github.ginrye.model.output.exporter.AbstractExporter;

public class FileOutputService extends AbstractExporterOutputService {
	
	private String directoryPath;
	
	public FileOutputService(String directoryPath) {
		this.directoryPath = directoryPath;
	}

	@Override
	public void output(ResultStore store) throws BusinessException {
		try {
			List<AbstractExporter> exporters = getExporters();
			for(AbstractExporter exporter : exporters) {
				String path = generatePath(store, exporter);
				OutputStream outputStream = new FileOutputStream(path);
				exporter.export(store, outputStream);
				outputStream.close();
			}
		} catch(IOException e) {
			throw new BusinessException(e);
		}
	}
	
	@Override
	protected String generatePath(ResultStore store, AbstractExporter exporter) {
		String path = null;
		if(!StringUtils.isBlank(directoryPath)) {
			path = directoryPath;
		} else {
			path = ".";
		}
		path += "/";
		if(!StringUtils.isBlank(store.getTableName())) {
			path += store.getTableName();
		} else {
			path += "unknown-table";
		}
		if(!StringUtils.isBlank(exporter.getSuffix())) {
			path += "." + exporter.getSuffix();
		}
		return path;
	}

	public String getDirectoryPath() {
		return directoryPath;
	}

	public void setDirectoryPath(String directoryPath) {
		this.directoryPath = directoryPath;
	}
}
