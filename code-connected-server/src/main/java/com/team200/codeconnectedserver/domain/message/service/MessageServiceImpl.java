package com.team200.codeconnectedserver.domain.message.service;

import com.team200.codeconnectedserver.domain.chat.exceptions.ChatNotFoundException;
import com.team200.codeconnectedserver.domain.chat.model.Chat;
import com.team200.codeconnectedserver.domain.chat.services.ChatService;
import com.team200.codeconnectedserver.domain.exceptions.ResourceNotFoundException;
import com.team200.codeconnectedserver.domain.message.model.Message;
import com.team200.codeconnectedserver.domain.message.repo.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageServiceImpl implements MessageService{
    private MessageRepo messageRepo;
    private ChatService chatService;

    @Autowired
    public MessageServiceImpl(MessageRepo messageRepo, ChatService chatService) {
        this.messageRepo = messageRepo;
        this.chatService = chatService;
    }

    @Override
    public Message create(Message message, Long id) throws ChatNotFoundException {
        Chat chat = chatService.getById(id);
        message.setChat(chat);
        return messageRepo.save(message);
    }

    @Override
    public Message getById(Long id) throws ResourceNotFoundException {
        Optional<Message> optional = messageRepo.findById(id);
        if(optional.isEmpty())
            throw new ResourceNotFoundException("Message Does Not Exist");
        return optional.get();
    }

    @Override
    public List<Message> getAllFromChat(Chat chat) {
        return messageRepo.findByChat(chat);
    }

    @Override
    public Iterable<Message> getAllBySenderId(Long id) {
        return messageRepo.findBySenderId(id);
    }

    @Override
    public Message update(Long id, Message messageDetail) {
        Message savedMessage = getById(id);
        savedMessage.setContent(messageDetail.getContent());
        return messageRepo.save(savedMessage);
    }

    @Override
    public void delete(Long id) {
        Message message  = getById(id);
        messageRepo.delete(message);

    }
}
