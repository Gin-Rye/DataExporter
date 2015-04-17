package com.github.ginrye.base.mapping.utils;

import org.dom4j.Element;

import com.github.ginrye.base.exception.BusinessException;
import com.github.ginrye.base.log.Logger;
import com.github.ginrye.base.mapping.InputServiceMapping;

public class InputServiceMappingUtils extends ClassMappingUtils<InputServiceMapping> {
	
	private static InputServiceMappingUtils instance;
	
	static {
		try {
			instance = new InputServiceMappingUtils();
		} catch(Exception e) {
			Logger.error(e);
		}
	}
	
	public static InputServiceMappingUtils getInstance() {
		return instance;
	}
	
	protected InputServiceMappingUtils() throws BusinessException {
		super();
	}
	
	@Override
	protected String getMappingLocation() {
		return "mapping/inputService.mapping.xml";
	}

	@Override
	protected InputServiceMapping createMapping() {
		return new InputServiceMapping();
	}
	
	@Override
	protected void initMapping(Element element, InputServiceMapping mapping) {
		super.initMapping(element, mapping);
	}
}
