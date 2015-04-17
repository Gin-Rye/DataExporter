package com.github.ginrye.base.resultstore;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.github.ginrye.base.exception.SystemException;

public class DBResultStore extends ResultStore {
	
	private ResultSet resultSet;
	private List<String> columnNames = new ArrayList<String>();
	private int size;
	
	public DBResultStore(ResultSet resultSet) {
		try {
			this.resultSet = resultSet;
			ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
			for(int column = 1; column <= resultSetMetaData.getColumnCount(); column++) {
				String columnName = resultSetMetaData.getColumnLabel(column);
				columnNames.add(columnName);
			}
			resultSet.last();
			size = resultSet.getRow();
			resultSet.beforeFirst();
		} catch(SQLException e) {
			throw new SystemException(e);
		}
	}

	@Override
	public int getColumnCount() {
		return columnNames.size();
	}
	
	@Override
	public List<String> getColumnNames() {
		return new ArrayList<String>(columnNames);
	}

	@Override
	public int getSize() {
		return size;
	}

	@Override
	public void close() {
		try {
			resultSet.close();
		} catch(SQLException e) {
			throw new SystemException(e);
		}
	}

	@Override
	public boolean isClosed() {
		try {
			return resultSet.isClosed();
		} catch(SQLException e) {
			throw new SystemException(e);
		}
	}

	@Override
	public int getCursor() {
		try {
			return resultSet.getRow();
		} catch(SQLException e) {
			throw new SystemException(e);
		}
	}

	@Override
	public void setCursor(int row) {
		try {
			resultSet.absolute(row + 1);
		} catch(SQLException e) {
			throw new SystemException(e);
		}
	}

	@Override
	public void resetCursor() {
		try {
			resultSet.beforeFirst();
		} catch(SQLException e) {
			throw new SystemException(e);
		}
	}

	@Override
	public void moveNext() {
		try {
			resultSet.next();
		} catch(SQLException e) {
			throw new SystemException(e);
		}
	}

	@Override
	public boolean hasNext() {
		try {
			if(size == 0) {
				return false;
			} else {
				return !resultSet.isLast();
			}
		} catch(SQLException e) {
			throw new SystemException(e);
		}
	}

	@Override
	public Object getColumnData(int column) {
		try {
			return resultSet.getObject(column + 1);
		} catch(SQLException e) {
			throw new SystemException(e);
		}
	}
}
