package com.github.ginrye.model.output.exporter;

import java.io.OutputStream;

import com.github.ginrye.base.exception.BusinessException;
import com.github.ginrye.base.resultstore.ResultStore;

public abstract class AbstractExporter {
	
	public void export(ResultStore store, OutputStream outputStream) throws BusinessException {
		store.resetCursor();
		exportData(store, outputStream);
	}
	
	protected abstract void exportData(ResultStore store, OutputStream outputStream) throws BusinessException;

	public abstract String getSuffix();
}
