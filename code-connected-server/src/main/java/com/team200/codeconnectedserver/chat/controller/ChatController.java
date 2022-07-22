package com.team200.codeconnectedserver.chat.controller;

import com.team200.codeconnectedserver.chat.model.Chat;
import com.team200.codeconnectedserver.chat.services.ChatService;
import com.team200.codeconnectedserver.chat.services.ChatServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/chats")
public class ChatController {
    private ChatService chatService;

    @Autowired
    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @GetMapping
    public ResponseEntity<List<Chat>> getAll(){
        List<Chat> chats = chatService.getAll();
        return new ResponseEntity<>(chats, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Chat> sendChat(@RequestBody Chat chat){
        //???????
        //How do I pass two profiles to the method in the constructor???
        Chat chat = chatService.create(Person1, Person2);
        return new ResponseEntity<>(chat,HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Chat> getById(PathVariable("id") Long id){
        Chat chat = chatService.getById(id);
        return new ResponseEntity<>(chat, HttpStatus.OK);
    }



}
