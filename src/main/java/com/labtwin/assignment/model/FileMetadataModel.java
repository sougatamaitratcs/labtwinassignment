package com.labtwin.assignment.model;

/**
 * This model class contains file metadata information
 * @author Sougata Maitra
 * @version 1.0
 *
 */
public class FileMetadataModel {
	
	private String fileName;
	private Long modifiedTime;
	private Long fileSize;
	 
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	public Long getModifiedTime() {
		return modifiedTime;
	}
	public void setModifiedTime(Long modifiedTime) {
		this.modifiedTime = modifiedTime;
	}
	public Long getFileSize() {
		return fileSize;
	}
	public void setFileSize(Long fileSize) {
		this.fileSize = fileSize;
	}
	


}
