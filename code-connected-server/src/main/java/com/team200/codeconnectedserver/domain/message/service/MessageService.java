package com.team200.codeconnectedserver.domain.message.service;

import com.team200.codeconnectedserver.domain.chat.exceptions.ChatNotFoundException;
import com.team200.codeconnectedserver.domain.chat.model.Chat;
import com.team200.codeconnectedserver.domain.exceptions.ResourceNotFoundException;
import com.team200.codeconnectedserver.domain.message.model.Message;

public interface MessageService {
    Message create(Message message,Long id) throws ChatNotFoundException;
    Message getById(Long id) throws ResourceNotFoundException;
    Iterable<Message> getAllFromChat(Chat chat);
    Iterable<Message> getAllBySenderId(Long id);
    Message update(Long id, Message message);
    boolean delete(Long id);

}
