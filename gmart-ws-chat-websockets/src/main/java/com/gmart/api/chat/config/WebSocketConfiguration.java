package com.gmart.api.chat.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

import com.gmart.api.chat.interceptors.HttpHandshakeInterceptor;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfiguration extends AbstractWebSocketMessageBrokerConfigurer{
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
    	 registry.setApplicationDestinationPrefixes("/ws");
         registry.enableSimpleBroker("WS_CHAT_TP","/topic/", "/queue/");

    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/gmart-chat-ws")
                .setAllowedOrigins("*")
                .withSockJS().setInterceptors(new HttpHandshakeInterceptor());
    }
}