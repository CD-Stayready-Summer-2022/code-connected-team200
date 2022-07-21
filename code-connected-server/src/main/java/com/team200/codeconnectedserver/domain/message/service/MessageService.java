package com.team200.codeconnectedserver.domain.message.service;

import com.team200.codeconnectedserver.domain.core.Exceptions.ResourceNotFoundException;
import com.team200.codeconnectedserver.domain.message.model.Message;

public interface MessageService {
    Message create(Message message);
    Message getById(Long id) throws ResourceNotFoundException;
    Message getBySenderId(Long id) throws ResourceNotFoundException;
    Message update(Long id, Message message);
    void delete(Long id);

}
