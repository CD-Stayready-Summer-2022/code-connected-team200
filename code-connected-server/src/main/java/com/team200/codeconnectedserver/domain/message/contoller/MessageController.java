package com.team200.codeconnectedserver.domain.message.contoller;

import com.team200.codeconnectedserver.domain.chat.exceptions.ChatNotFoundException;
import com.team200.codeconnectedserver.domain.message.model.Message;
import com.team200.codeconnectedserver.domain.message.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v2/messages")
public class MessageController {
    @Autowired
    private MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping("{id}")
    //request from all the messages will be in the chat controller
    public ResponseEntity<Message> createMessage(@RequestBody Message message, @PathVariable("id") Long id) {
        Message saveMessage;
        try {
            saveMessage = messageService.create(message, id);
        } catch (ChatNotFoundException e) {
            throw new RuntimeException(e);
        }
        return new ResponseEntity<>(saveMessage, HttpStatus.CREATED);
    }

    @GetMapping("message/{id}")
    public ResponseEntity<Message> getMessageByID(@PathVariable Long id) {
        Message message = messageService.getById(id);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @GetMapping("/by-sender")
    public ResponseEntity<Message> getMessagesBySenderID(@RequestParam(name = "sender") Long id) {
        Message message = messageService.getById(id);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Message> update(@PathVariable("id") Long id, @RequestBody Message messageDetail){
        Message message = messageService.update(id, messageDetail);
        return new ResponseEntity<>(message, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("message/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") Long id){
        messageService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
