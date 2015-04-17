package com.github.ginrye.model.output.factory;

import com.github.ginrye.model.output.FileOutputService;

public class FileOutputServiceFactory implements OutputServiceFactory<FileOutputService> {

	private String directoryPath;
	
	@Override
	public FileOutputService create() {
		FileOutputService fileOutputService = new FileOutputService(directoryPath);
		return fileOutputService;
	}

	public String getDirectoryPath() {
		return directoryPath;
	}

	public void setDirectoryPath(String directoryPath) {
		this.directoryPath = directoryPath;
	}
}
