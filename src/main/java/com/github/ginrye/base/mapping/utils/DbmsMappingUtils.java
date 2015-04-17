package com.github.ginrye.base.mapping.utils;

import org.dom4j.Element;

import com.github.ginrye.base.exception.BusinessException;
import com.github.ginrye.base.log.Logger;
import com.github.ginrye.base.mapping.DbmsMapping;

public class DbmsMappingUtils extends BaseMappingUtils<DbmsMapping> {
	
	private static DbmsMappingUtils instance;
	
	static {
		try {
			instance = new DbmsMappingUtils();
		} catch(Exception e) {
			Logger.error(e);
		}
	}
	
	public static DbmsMappingUtils getInstance() {
		return instance;
	}
	
	protected DbmsMappingUtils() throws BusinessException {
		super();
	}
	
	@Override
	protected String getMappingLocation() {
		return "mapping/dbms.mapping.xml";
	}

	@Override
	protected DbmsMapping createMapping() {
		return new DbmsMapping();
	}
	
	@Override
	protected void initMapping(Element element, DbmsMapping mapping) {
		super.initMapping(element, mapping);
		String driverClassName = element.elementTextTrim("driverClassName");
		String connectionUrlTemplate = element.elementTextTrim("connectionUrlTemplate");
		mapping.setDriverClassName(driverClassName);
		mapping.setConnectionUrlTemplate(connectionUrlTemplate);
	}
	
	public String getDriverClassName(String type) throws BusinessException {
		
		DbmsMapping mapping = getMapping(type);
		return mapping.getDriverClassName();
	}
	
	public String getConnectionUrl(String type, 
			String host, int port, String instance) throws BusinessException {
		
		DbmsMapping mapping = getMapping(type);
		String connectionUrl = mapping.getConnectionUrlTemplate();
		connectionUrl = connectionUrl.replace("${host}", host);
		connectionUrl = connectionUrl.replace("${port}", Integer.toString(port));
		connectionUrl = connectionUrl.replace("${instance}", instance);
		return connectionUrl;
	}
}
