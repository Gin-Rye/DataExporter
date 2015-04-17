package com.github.ginrye.model.input.factory;

import com.github.ginrye.base.exception.BusinessException;
import com.github.ginrye.base.log.Logger;
import com.github.ginrye.model.input.DBInputService;

public class DBInputServiceFactory implements InputServiceFactory<DBInputService> {

	private String dbms;
	private String host;
	private int port;
	private String instance;
	private String username;
	private String password;
	
	@Override
	public DBInputService create() {
		try {
			DBInputService dbInputService = new DBInputService(dbms, host, port, instance, username, password);
			return dbInputService;
		} catch(BusinessException e) {
			Logger.error(e);
			return null;
		}
	}

	public String getDbms() {
		return dbms;
	}

	public void setDbms(String dbms) {
		this.dbms = dbms;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getInstance() {
		return instance;
	}

	public void setInstance(String instance) {
		this.instance = instance;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
