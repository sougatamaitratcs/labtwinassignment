package com.labtwin.assignment;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

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
    
    
    private String restUrl;
    
    @Before 
    public void setup() {
        restUrl = "http://localhost:"+port+"/";
    }
    
    @Test
    public void b_testFileMetaInfo() {  
    	String uri = restUrl+"hello/sougata";
        RestTemplate restTemplate = new RestTemplate();
        String responseMessage = restTemplate.getForObject(uri, String.class);
        assertNotNull(responseMessage); 
       
    }
 
}
