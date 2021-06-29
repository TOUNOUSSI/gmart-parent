package com.gmart.api.chat.entities;

import lombok.Data;

@Data
public class ChatMessage {
	public enum MessageType {
        CHAT,
        JOIN,
        LEAVE
    }
    private String content;
    private String receiver;
    private String sender;
     private MessageType type;
}
