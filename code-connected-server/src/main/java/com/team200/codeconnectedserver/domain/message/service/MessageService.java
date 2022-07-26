package com.team200.codeconnectedserver.domain.message.service;

import com.team200.codeconnectedserver.domain.core.Exceptions.ResourceNotFoundException;
import com.team200.codeconnectedserver.domain.exceptions.ResourceNotFoundException;
import com.team200.codeconnectedserver.domain.message.model.Message;

import java.util.List;

public interface MessageService {
    Message create(Message message);
    Message getById(Long id) throws ResourceNotFoundException;
    Iterable<Message> getBySenderId(Long id);
    Message update(Long id, Message message);
    void delete(Long id);

}
