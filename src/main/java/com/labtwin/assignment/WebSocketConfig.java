package com.labtwin.assignment;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * This is configuration class for Spring boot .
 * Using STOMP with in memory message broker
 * @author Sougata Maitra
 *
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer{
	
	   
		/** 
		 * Register STOMP broker
		 * Register Application URI prefix
		 */
	    @Override
	    public void configureMessageBroker(MessageBrokerRegistry registry) {
	    	registry.enableSimpleBroker("/topic");
	        registry.setApplicationDestinationPrefixes("/labtwin");
	    }
	    
	    /**
	     * Register's Websocket endpoint services
	     */
	     @Override
		 public void registerStompEndpoints(StompEndpointRegistry registry) {
	    	 registry.addEndpoint("/application").withSockJS();
		 }

}
