package com.example.band_notify.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebsocketConfiguration implements WebSocketMessageBrokerConfigurer {

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        WebSocketMessageBrokerConfigurer.super.registerStompEndpoints(registry);

        // 클라에서 웹소켓 STOMP 연결을 위해 지정할 엔드포인트..
        // SockJS는 WebSocket이 지원되지 않는 일부 브라우저에서도 WebSocket 연결을 에뮬레이트하게 도와줌..
        registry.addEndpoint("/stomp-endpoint-0").setAllowedOriginPatterns("*")
                .withSockJS();

        registry.addEndpoint("/stomp-endpoint-1").setAllowedOriginPatterns("*")
                .withSockJS();

        registry.addEndpoint("/stomp-endpoint-2").setAllowedOriginPatterns("*")
                .withSockJS();
    }
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        WebSocketMessageBrokerConfigurer.super.configureMessageBroker(registry);

        // "/topic" 으로 시작하는 대상 주제를 구독하는 클라이언트에게 메시지를 브로드캐스트하는 데 사용..
        // 메시지를 구독하는 클라이언트들에게 메시지를 보내는 메시지 브로커를 활성화..
        registry.enableSimpleBroker("/topic");

        // 클라이언트가 메시지를 송신할 때 사용하는 목적지 접두어(prefix)를 설정 ..
        registry.setApplicationDestinationPrefixes("/app");
    }
}