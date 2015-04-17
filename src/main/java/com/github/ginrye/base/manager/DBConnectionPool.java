package com.github.ginrye.base.manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.github.ginrye.base.exception.BusinessException;
import com.github.ginrye.base.mapping.utils.DbmsMappingUtils;

public class DBConnectionPool {
	private static Map<String, Connection> connectionMap = new HashMap<String, Connection>();
	
	public static Connection getConnection(String dbms, String host, int port, 
			String instance, String username, String password) throws BusinessException {
		try {

			String url = DbmsMappingUtils.getInstance().getConnectionUrl(dbms, host, port, instance);
			String mapKey = url + "|" + username + "|" + password;
			if(!connectionMap.containsKey(mapKey)) {
				String driverClassName = DbmsMappingUtils.getInstance().getDriverClassName(dbms);
				Class.forName(driverClassName);
				Connection connection = DriverManager.getConnection(url, username, password);
				connectionMap.put(mapKey, connection);
			}
			return connectionMap.get(mapKey);
		} catch(BusinessException e) {
			throw new BusinessException(e);
		} catch (ClassNotFoundException e) {
			throw new BusinessException(e);
		} catch (SQLException e) {
			throw new BusinessException(e);
		}
	}
}
