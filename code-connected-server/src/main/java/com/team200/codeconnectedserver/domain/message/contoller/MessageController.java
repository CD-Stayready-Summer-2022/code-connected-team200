package com.team200.codeconnectedserver.domain.message.contoller;

import com.team200.codeconnectedserver.domain.message.model.Message;
import com.team200.codeconnectedserver.domain.message.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/message")
public class MessageController {
    @Autowired
    private MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping
    public ResponseEntity<Message> createMessage(@RequestBody Message message) {
        Message saveMessage = messageService.create(message);
        return new ResponseEntity<>(saveMessage, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Message> getMessageByID(@PathVariable Long id) {
        Message message = messageService.getById(id);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @GetMapping("by-sender")
    public ResponseEntity<Message> getMessagesBySenderID(@RequestParam(name = "sender") Long id) {
        Message message = messageService.getById(id);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Message> updated(@PathVariable("id") Long id, @RequestBody Message messageDetail){
        Message message = messageService.update(id, messageDetail);
        return new ResponseEntity<>(message, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") Long id){
        messageService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
