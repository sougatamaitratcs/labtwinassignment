package com.labtwin.assignment.model;
/**
 * Model class for string file data
 * @author sougata maitra
 * @version 1.0
 */
public class FileDataModel {
	
	private String fileMessage;
	private FileMetadataModel fileMetamodel;
	public String getFileMessage() {
		return fileMessage;
	}
	public void setFileMessage(String fileMessage) {
		this.fileMessage = fileMessage;
	}
	public FileMetadataModel getFileMetamodel() {
		return fileMetamodel;
	}
	public void setFileMetamodel(FileMetadataModel fileMetamodel) {
		this.fileMetamodel = fileMetamodel;
	}
	
	

}
 