package com.github.ginrye.model.input;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.sql.Statement;

import com.github.ginrye.base.exception.BusinessException;
import com.github.ginrye.base.exception.SystemException;
import com.github.ginrye.base.manager.DBConnectionPool;
import com.github.ginrye.base.resultstore.DBResultStore;
import com.github.ginrye.model.input.query.Query;

public class DBInputService implements InputService<String> {
	
	protected Connection connection;
	
	public DBInputService(String dbms, String host, int port, 
			String instance, String username, String password) throws BusinessException {
		connection = DBConnectionPool.getConnection(dbms, host, port, instance, username, password);
	}
	
	@Override
	public DBResultStore input(Query<String> query) throws BusinessException {
		try {
			Statement stmt = connection.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = stmt.executeQuery(query.getCommand());
			DBResultStore dbResultStore = new DBResultStore(rs);
			dbResultStore.setTableName(query.getTableName());
			stmt.closeOnCompletion();
			return dbResultStore;
		} catch(SQLSyntaxErrorException e) {
			throw new BusinessException("SQL is error", e);
		} catch(SQLException e) {
			throw new SystemException(e);
		}
	}
}
