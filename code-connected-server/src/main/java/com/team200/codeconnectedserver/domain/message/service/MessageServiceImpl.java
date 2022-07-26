package com.team200.codeconnectedserver.domain.message.service;

import com.team200.codeconnectedserver.domain.chat.model.Chat;
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

    @Autowired
    public MessageServiceImpl(MessageRepo messageRepo) {
        this.messageRepo = messageRepo;
    }

    @Override
    public Message create(Message message) {
        return messageRepo.save(message);
    }

    @Override
    public Message getById(Long id) {
        Optional<Message> optional = messageRepo.findById(id);
        if(optional.isPresent())
            throw new ResourceNotFoundException("Message Does Not Exist");
        return optional.get();
    }

    @Override
    public Iterable<Message> getBySenderId(Long id) {
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
