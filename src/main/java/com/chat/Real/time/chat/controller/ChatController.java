package com.chat.Real.time.chat.controller;


import com.chat.Real.time.chat.model.ChatMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChatController {

    @MessageMapping("/sendMessage") //when a client wants to send a message they can send to this endpoint
    @SendTo("/topic/messages") // this annotation tells spring to broadcast the return value from this sendMessage() to all the clients who are subscribed to this topic
    public ChatMessage sendMessage(ChatMessage message){
        return message;
    }


    // For thymeleaf
    @GetMapping("/chat")
    public String chat(){
        return "chat";
    }
}
