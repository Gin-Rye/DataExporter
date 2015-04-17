package com.github.ginrye.model.output;

import java.util.List;

import com.github.ginrye.base.resultstore.ResultStore;
import com.github.ginrye.model.output.exporter.AbstractExporter;

public abstract class AbstractExporterOutputService implements OutputService {
	
	private List<AbstractExporter> exporters;

	public List<AbstractExporter> getExporters() {
		return exporters;
	}

	public void setExporters(List<AbstractExporter> exporters) {
		this.exporters = exporters;
	}
	
	protected abstract String generatePath(ResultStore store, AbstractExporter exporter);
}
