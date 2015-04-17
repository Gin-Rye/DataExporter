package com.github.ginrye.base.mapping.utils;

import org.dom4j.Element;

import com.github.ginrye.base.exception.BusinessException;
import com.github.ginrye.base.mapping.ClassMapping;

public abstract class ClassMappingUtils<T extends ClassMapping> extends BaseMappingUtils<T> {

	protected ClassMappingUtils() throws BusinessException {
		super();
	}

	@Override
	protected void initMapping(Element element, T mapping) {
		super.initMapping(element, mapping);
		String className = element.elementText("className");
		mapping.setClassName(className);
	}

	
	public String getClassName(String type) throws BusinessException {
		T mapping = getMapping(type);
		return mapping.getClassName();
	}
}
