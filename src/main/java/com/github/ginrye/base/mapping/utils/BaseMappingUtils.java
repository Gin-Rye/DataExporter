package com.github.ginrye.base.mapping.utils;

import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.github.ginrye.base.exception.BusinessException;
import com.github.ginrye.base.mapping.BaseMapping;

public abstract class BaseMappingUtils<T extends BaseMapping> {
	
	protected Map<String, T> mappings = new HashMap<String, T>();
	
	protected BaseMappingUtils() throws BusinessException {
		initialize();
	}
	
	public T getMapping(String type) throws BusinessException {
		if(type == null) {
			throw new BusinessException("dbms is null");
		} else {
			T mapping = mappings.get(type.toUpperCase());
			if(mapping == null) {
				throw new BusinessException("No such mapping: type = " + type);
			} else {
				return mapping;
			}
		}
	}
	
	protected void initialize() throws BusinessException {
		try {
			URL url = Thread.currentThread().getContextClassLoader().getResource(getMappingLocation());
			SAXReader reader = new SAXReader();
			Document document = reader.read(url);
			Element root = document.getRootElement();
			Iterator<?> iterator = root.elementIterator();
			while(iterator.hasNext()) {
				Element element = (Element) iterator.next();
				T mapping = createMapping();
				initMapping(element, mapping);
				mappings.put(mapping.getType().toUpperCase(), mapping);
			}
		} catch(DocumentException e) {
			throw new BusinessException(e);
		}
	}
	
	protected abstract String getMappingLocation();
	
	protected abstract T createMapping();
	
	protected void initMapping(Element element, T mapping) {
		String type = element.elementTextTrim("type");
		mapping.setType(type);
	}
}
