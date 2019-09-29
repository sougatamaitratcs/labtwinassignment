package com.labtwin.assignment;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.junit.Assert.assertNotNull;

import java.lang.reflect.Type;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.simp.stomp.StompFrameHandler;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandlerAdapter;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;
import org.springframework.web.socket.sockjs.client.SockJsClient;
import org.springframework.web.socket.sockjs.client.Transport;
import org.springframework.web.socket.sockjs.client.WebSocketTransport;

import com.labtwin.assignment.model.FileDataModel;
import com.labtwin.assignment.model.FileMetadataModel;


/**
 * This is integration testclass
 * @author 605173
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LabtwinAssignmentTest {
	
	@LocalServerPort
    private int port;
    
	private String URL;
    private String restUrl;
    
    private static final String SEND_CREATE_ENDPOINT = "/labtwin/store";
    private static final String SUBSCRIBE_CREATE_ENDPOINT = "/topic/publish";
  
    
    private CompletableFuture<FileDataModel> completableFuture;
    
    @Before 
    public void setup() {
        restUrl = "http://localhost:"+port+"/";
        URL = "ws://localhost:" + port + "/application";
        completableFuture = new CompletableFuture<>(); 
    }
    @Test
    public void a_testStoreFile() throws URISyntaxException, InterruptedException, ExecutionException, TimeoutException {
        WebSocketStompClient stompClient = new WebSocketStompClient(new SockJsClient(createTransportClient()));
        stompClient.setMessageConverter(new MappingJackson2MessageConverter());
        StompSession stompSession = stompClient.connect(URL, new StompSessionHandlerAdapter() {
        }).get(5, SECONDS);
        
        FileDataModel dataModelRequest = new FileDataModel();
        FileMetadataModel filemetainfo = new FileMetadataModel();
        filemetainfo.setFileName("mytestfile4");
        dataModelRequest.setFileMetamodel(filemetainfo);
        
        dataModelRequest.setFileMessage("This is my file first send");
        stompSession.subscribe(SUBSCRIBE_CREATE_ENDPOINT, new FileStompFrameHandler());
        stompSession.send(SEND_CREATE_ENDPOINT, dataModelRequest);
        
        FileDataModel fileData = completableFuture.get(10, SECONDS);
        assertNotNull(fileData);
    }
    
    private List<Transport> createTransportClient() {
        List<Transport> transports = new ArrayList<>(1);
        transports.add(new WebSocketTransport(new StandardWebSocketClient()));
        return transports;
    }
    
    private class FileStompFrameHandler implements StompFrameHandler {
        
        @Override
		public Type getPayloadType(StompHeaders headers) { 
			// TODO Auto-generated method stub
			return FileDataModel.class;
		}
        

		@Override
		public void handleFrame(StompHeaders headers, Object payload) {
			completableFuture.complete((FileDataModel) payload);
			
		}
    }
    
    @Test
    public void b_testFileMetaInfo() {  
    	String uri = restUrl+"filemetadata/mytestfile4";
        RestTemplate restTemplate = new RestTemplate();
        FileMetadataModel fileMeta = restTemplate.getForObject(uri, FileMetadataModel.class);
        assertNotNull(fileMeta); 
       
    }
    
    @Test
    public void c_testFileMetaInfo() {  
    	String uri = restUrl+"hello/sougata";
        RestTemplate restTemplate = new RestTemplate();
        String responseMessage = restTemplate.getForObject(uri, String.class);
        assertNotNull(responseMessage); 
       
    }
 
}
