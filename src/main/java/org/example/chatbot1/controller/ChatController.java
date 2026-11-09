package org.example.chatbot1.controller;

import org.apache.http.HttpStatus;
import org.example.chatbot1.services.ChatService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ChatController {

    private final ChatService chatService;

    public ChatController(ChatService chatService){
        this.chatService = chatService;
    }

    @GetMapping
    public String get(){
        return "Hello";
    }

    @GetMapping("/chat")
    public ResponseEntity ask(@RequestBody String prompt){
        String response = chatService.generateResponse(prompt);
        return
                ResponseEntity.status(HttpStatus.SC_OK).body(response);
    }
}
