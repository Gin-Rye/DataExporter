package com.github.ginrye.base.mapping;

public class DbmsMapping extends BaseMapping {
	
	private String driverClassName;
	private String connectionUrlTemplate;
	
	public String getDriverClassName() {
		return driverClassName;
	}
	public void setDriverClassName(String driverClassName) {
		this.driverClassName = driverClassName;
	}
	public String getConnectionUrlTemplate() {
		return connectionUrlTemplate;
	}
	public void setConnectionUrlTemplate(String connectionUrlTemplate) {
		this.connectionUrlTemplate = connectionUrlTemplate;
	}
}
