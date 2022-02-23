package com.mishrole.chatapp.controller;

import java.util.Date;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.mishrole.chatapp.entity.Message;

@Controller
public class ChatController {
	// Listen events
	@MessageMapping
	// Notify clients
	@SendTo("/chat/message")
	public Message getMessage(Message message) {
		message.setCreatedAt(new Date());
		message.setContent("Received by broker: " + message.getContent());
		return message;
	}
	
}
