package com.github.ginrye.base.mapping.utils;

import org.dom4j.Element;

import com.github.ginrye.base.exception.BusinessException;
import com.github.ginrye.base.log.Logger;
import com.github.ginrye.base.mapping.OutputServiceMapping;

public class OutputServiceMappingUtils extends ClassMappingUtils<OutputServiceMapping> {
	
	private static OutputServiceMappingUtils instance;
	
	static {
		try {
			instance = new OutputServiceMappingUtils();
		} catch(Exception e) {
			Logger.error(e);
		}
	}
	
	public static OutputServiceMappingUtils getInstance() {
		return instance;
	}
	
	protected OutputServiceMappingUtils() throws BusinessException {
		super();
	}
	
	@Override
	protected String getMappingLocation() {
		return "mapping/outputService.mapping.xml";
	}

	@Override
	protected OutputServiceMapping createMapping() {
		return new OutputServiceMapping();
	}
	
	@Override
	protected void initMapping(Element element, OutputServiceMapping mapping) {
		super.initMapping(element, mapping);
	}
}
