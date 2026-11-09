package org.example.chatbot1.services;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class ChatService {
    private final ChatClient chatClient;

    public ChatService(ChatClient.Builder builder){
        this.chatClient= builder.build();
    }

    public String generateResponse(String prompt){
        return chatClient.prompt()
                .user(prompt)
                .call()
                .content();
    }
}
