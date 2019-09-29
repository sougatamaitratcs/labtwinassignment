package com.labtwin.assignment.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.labtwin.assignment.model.FileDataModel;
import com.labtwin.assignment.service.FileHandleService;
/**
 * This class handles exposed methods for Websocket interactions
 * @author Sougata Maitra
 *
 */
@Controller
public class FileController {
	
	@Autowired
	FileHandleService fileHandleService;
	
	@MessageMapping("/store")
    
	@SendTo("/topic/publish")
    public FileDataModel storeFile(@Payload FileDataModel fileData) throws IOException {
		return fileHandleService.saveFile(fileData);
    }
}