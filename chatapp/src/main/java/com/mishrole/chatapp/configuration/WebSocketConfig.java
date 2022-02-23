package com.mishrole.chatapp.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
// Habilitar Spring WebSocket
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		// Ruta de Broker en Spring
		registry.addEndpoint("/chat-websocket")
		// Ruta por defecto de Angular
		.setAllowedOrigins("http://localhost:4200")
		.withSockJS();
	}
	
	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {
		// Prefijo para acceder a los eventos
		registry.enableSimpleBroker("/chat/");
		// Prefijo del destino
		registry.setApplicationDestinationPrefixes("/app");
	}
	
}
