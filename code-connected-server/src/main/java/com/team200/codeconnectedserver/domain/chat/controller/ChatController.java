package com.team200.codeconnectedserver.domain.chat.controller;

import com.team200.codeconnectedserver.domain.chat.exceptions.ChatNotFoundException;
import com.team200.codeconnectedserver.domain.chat.model.Chat;
import com.team200.codeconnectedserver.domain.chat.services.ChatService;
import com.team200.codeconnectedserver.domain.message.model.Message;
import com.team200.codeconnectedserver.domain.message.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/chats")
public class ChatController {
    @Autowired
    private ChatService chatService;

    @Autowired
    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @PostMapping
    public ResponseEntity<Chat> createChat() {
        Chat saveChat = chatService.create();
        return new ResponseEntity<>(saveChat, HttpStatus.CREATED);
    }
    /*
    @GetMapping("{id}")
    public ResponseEntity<Chat> getChatById(@PathVariable Long id) {
        Chat chat = chatService.getById(id);
        return new ResponseEntity<>(chat, HttpStatus.OK);
    }

<<<<<<< HEAD
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") Long id){
        chatService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
=======
     */




}
