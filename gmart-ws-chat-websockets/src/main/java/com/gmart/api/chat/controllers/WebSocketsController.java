package com.gmart.api.chat.controllers;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.SimpMessageType;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.socket.WebSocketHandler;

import com.gmart.api.chat.entities.ChatMessage;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/ws")
@Slf4j
public class WebSocketsController {


	@Autowired
	private SimpMessageSendingOperations messagingTemplate;

	@MessageMapping("/send/message")
	public void sendMessage(@Payload ChatMessage chatMessage, SimpMessageHeaderAccessor  headerAccessor) {

		log.info("Hello ");
		log.info("/topic/public-" + chatMessage.getReceiver() + "-" + chatMessage.getSender());
		 String sessionId = headerAccessor.getSessionAttributes().get("sessionId").toString();
		//this.messagingTemplate.convertAndSendToUser(sessionId,"/topic/public",chatMessage, headerAccessor.getMessageHeaders());
		this.messagingTemplate.convertAndSend(
				"/topic/public-" + chatMessage.getReceiver() + "-" + chatMessage.getSender(), chatMessage);


		log.info("Creation ended");

	}

}
