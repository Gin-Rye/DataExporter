package com.github.ginrye.model.output.exporter;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Date;
import java.util.List;

import com.github.ginrye.base.exception.BusinessException;
import com.github.ginrye.base.resultstore.ResultStore;
import com.github.ginrye.base.utils.DateUtils;

public class FlatXmlExporter extends AbstractExporter {

	@Override
	protected void exportData(ResultStore store, OutputStream outputStream) throws BusinessException {
		try {
			String tableName = store.getTableName();
			List<String> columnNameList = store.getColumnNames();
			Writer writer = new OutputStreamWriter(outputStream);
			writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n");
			writer.write("<dataset>\r\n");
			writer.flush();
			while (store.hasNext()) {
				store.moveNext();
				writer.write("   <" + tableName);
				for (int i = 0; i < columnNameList.size(); i++) {
					String columnName = columnNameList.get(i);
					writer.write(" " + columnName + "=");
					Object object = store.getColumnData(i);
					String value = "\"";
					if(object != null) {
						if (object instanceof Date) {
							value += DateUtils.dateToString((Date) object,
									"yyyy-MM-dd HH:mm:ss");
						} else {
							value += object.toString();
						}
					}
					value += "\"";
					writer.write(value);
				}
				writer.write("/>\r\n");
				writer.flush();
			}
			writer.write("</dataset>\r\n");
			writer.flush();
		} catch(IOException e) {
			throw new BusinessException(e);
		}
	}

	@Override
	public String getSuffix() {
		return "ds.xml";
	}

}
