package com.github.ginrye.business.io;

import com.github.ginrye.base.log.Logger;
import com.github.ginrye.base.resultstore.ResultStore;
import com.github.ginrye.model.input.InputService;
import com.github.ginrye.model.input.query.Query;
import com.github.ginrye.model.output.OutputService;

public class IOWorker<T> implements Runnable {
	
	private InputService<T> inputService;
	private Query<T> query;
	private OutputService outputService;

	@Override
	public void run() {
		try {
			Logger.info("[worker start] " + query.getTableName());
			ResultStore store = inputService.input(query);
			outputService.output(store);
			store.close();
			Logger.info("[worker stop] " + query.getTableName());
		} catch(Exception e) {
			Logger.error(e);
		}
	}

	public InputService<T> getInputService() {
		return inputService;
	}

	public void setInputService(InputService<T> inputService) {
		this.inputService = inputService;
	}

	public Query<T> getQuery() {
		return query;
	}

	public void setQuery(Query<T> query) {
		this.query = query;
	}

	public OutputService getOutputService() {
		return outputService;
	}

	public void setOutputService(OutputService outputService) {
		this.outputService = outputService;
	}
}
