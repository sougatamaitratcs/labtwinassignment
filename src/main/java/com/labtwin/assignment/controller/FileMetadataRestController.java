package com.labtwin.assignment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.labtwin.assignment.model.FileMetadataModel;
import com.labtwin.assignment.service.FileHandleService;

/**
 * This class handles exposed REST services for file metadata 
 * @author Sougata Maitra
 *
 */
@RestController
public class FileMetadataRestController {
	
	@Autowired
	FileHandleService fileHandlingService;
	
	@GetMapping(value="/filemetadata/{name}",produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseStatus(HttpStatus.OK)
	public FileMetadataModel getFileInfo(@PathVariable("name") String fileName) {
		return fileHandlingService.getFileMetaInfo(fileName);
	}

}
