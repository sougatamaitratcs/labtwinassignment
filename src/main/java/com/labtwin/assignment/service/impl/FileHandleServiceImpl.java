package com.labtwin.assignment.service.impl;

import java.io.IOException;

import org.springframework.stereotype.Service;

import com.labtwin.assignment.model.FileDataModel;
import com.labtwin.assignment.model.FileMetadataModel;
import com.labtwin.assignment.service.FileHandleService;

/**
 * This is the implementation of Service class contains business information for all service
 * @author Sougata Maitra
 * @version 1.0
 *
 */
@Service
public class FileHandleServiceImpl implements FileHandleService{

	@Override
	public FileDataModel saveFile(FileDataModel filedata) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FileMetadataModel getFileMetaInfo(String fileId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String helloService(String helloMessage) {
		// TODO Auto-generated method stub
		return "Hii"+helloMessage;
	}

}
