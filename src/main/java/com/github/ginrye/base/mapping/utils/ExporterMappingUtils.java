package com.github.ginrye.base.mapping.utils;

import org.dom4j.Element;

import com.github.ginrye.base.exception.BusinessException;
import com.github.ginrye.base.log.Logger;
import com.github.ginrye.base.mapping.ExporterMapping;

public class ExporterMappingUtils extends ClassMappingUtils<ExporterMapping> {
	
	private static ExporterMappingUtils instance;
	
	static {
		try {
			instance = new ExporterMappingUtils();
		} catch(Exception e) {
			Logger.error(e);
		}
	}
	
	public static ExporterMappingUtils getInstance() {
		return instance;
	}
	
	protected ExporterMappingUtils() throws BusinessException {
		super();
	}
	
	@Override
	protected String getMappingLocation() {
		return "mapping/exporter.mapping.xml";
	}

	@Override
	protected ExporterMapping createMapping() {
		return new ExporterMapping();
	}
	
	@Override
	protected void initMapping(Element element, ExporterMapping mapping) {
		super.initMapping(element, mapping);
	}
}
