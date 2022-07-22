package com.team200.codeconnectedserver.domain.message.service;

import com.team200.codeconnectedserver.domain.chat.model.Chat;
import com.team200.codeconnectedserver.domain.core.Exceptions.ResourceNotFoundException;
import com.team200.codeconnectedserver.domain.message.model.Message;

public interface MessageService {
    Message create(Message message,Chat chat);
    Message getById(Long id) throws ResourceNotFoundException;
    Iterable<Message> getAllFromChat(Chat chat);
    Iterable<Message> getAllBySenderId(Long id);
    Message update(Long id, Message message);
    void delete(Long id);

}
