package com.team200.codeconnectedserver.domain.chat.services;

import com.team200.codeconnectedserver.domain.chat.model.Chat;

import java.util.Date;

public interface ChatService {
    Chat create();

    Chat getById(Long chatId);

    Iterable<Chat> getByDate(Date date);

    void delete(Long id);
}
