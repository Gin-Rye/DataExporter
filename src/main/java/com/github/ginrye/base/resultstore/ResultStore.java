package com.github.ginrye.base.resultstore;

import java.util.List;

public abstract class ResultStore {
	
	private String tableName;
	
	public ResultStore() {}
	
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	
	public String getTableName() {
		return tableName;
	}
	
	public abstract int getColumnCount();
	
	public abstract List<String> getColumnNames();
	
	public abstract int getSize();
	
	public abstract void close();
	
	public abstract boolean isClosed();
	
	public abstract int getCursor();
	
	public abstract void setCursor(int row);
	
	public abstract void resetCursor();
	
	public abstract void moveNext();
	
	public abstract boolean hasNext();
	
	public abstract Object getColumnData(int column);
}
