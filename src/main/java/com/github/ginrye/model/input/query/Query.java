package com.github.ginrye.model.input.query;

public class Query<T> {
	
	protected String tableName;
	protected T command;

	public T getCommand() {
		return command;
	}

	public void setCommand(T command) {
		this.command = command;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
}
