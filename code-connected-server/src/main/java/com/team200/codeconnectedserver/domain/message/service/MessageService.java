package com.team200.codeconnectedserver.domain.message.service;

<<<<<<< HEAD
import com.team200.codeconnectedserver.domain.core.Exceptions.ResourceNotFoundException;
=======
import com.team200.codeconnectedserver.domain.chat.exceptions.ChatNotFoundException;
import com.team200.codeconnectedserver.domain.chat.model.Chat;
>>>>>>> 5c43849cffd951cd0e35514b76a5702d1cacd168
import com.team200.codeconnectedserver.domain.exceptions.ResourceNotFoundException;
import com.team200.codeconnectedserver.domain.message.model.Message;

import java.util.List;

public interface MessageService {
    Message create(Message message,Long id) throws ChatNotFoundException;
    Message getById(Long id) throws ResourceNotFoundException;
    Iterable<Message> getAllFromChat(Chat chat);
    Iterable<Message> getAllBySenderId(Long id);
    Message update(Long id, Message message);
    boolean delete(Long id);

}
