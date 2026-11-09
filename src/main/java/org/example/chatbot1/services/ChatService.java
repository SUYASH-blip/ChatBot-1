package org.example.chatbot1.services;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.messages.Message;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChatService {
    private final ChatClient chatClient;

    private List<Message> history = new ArrayList<>();

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
