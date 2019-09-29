package com.labtwin.assignment.service.impl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
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

	/**
	 * Storing File information
	 * @throws IOException 
	 */
	public FileDataModel saveFile(FileDataModel filedata) throws IOException {
		 File f = new File(filedata.getFileMetamodel().getFileName());
        if(!f.exists()) {
        	 f.createNewFile();
        }
        FileWriter fr = new FileWriter(f, true);
        BufferedWriter br = new BufferedWriter(fr);
        br.write(filedata.getFileMessage());
        if(br!=null) br.close(); 
        if(fr!=null) fr.close();
        long currentTime = System.currentTimeMillis();
        FileDataModel fileData = new FileDataModel();
        FileMetadataModel metadataModel = new FileMetadataModel();
        metadataModel.setModifiedTime(currentTime);
        fileData.setFileMetamodel(metadataModel);
        return fileData; 
	}
	/**
	 * Retrieve file meta info by filename  
	 */
	
	public FileMetadataModel getFileMetaInfo(String fileName) {
		// TODO Auto-generated method stub
		FileMetadataModel fileMetaModel = new FileMetadataModel();
		File f = new File(fileName);
		if(f.exists()) {
			long modifiedtime = f.lastModified();
			fileMetaModel.setModifiedTime(modifiedtime);
			fileMetaModel.setFileSize(f.length());
			fileMetaModel.setFileName(f.getName());
		}
		return fileMetaModel;
	}

	@Override
	public String helloService(String helloMessage) {
		// TODO Auto-generated method stub
		return "Hii"+helloMessage;
	} 

}
