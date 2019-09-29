package com.labtwin.assignment.service;

import java.io.IOException;

import com.labtwin.assignment.model.FileDataModel;
import com.labtwin.assignment.model.FileMetadataModel;


/**
 * This is the service interface for handling all business related logic
 * @author Sougata Maitra
 *
 */
public interface FileHandleService {
	
	public FileDataModel saveFile(FileDataModel filedata) throws IOException;
	public FileMetadataModel getFileMetaInfo(String fileId);
	public String helloService(String helloMessage);

}
