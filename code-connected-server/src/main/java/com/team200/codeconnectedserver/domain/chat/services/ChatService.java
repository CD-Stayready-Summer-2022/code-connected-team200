package com.team200.codeconnectedserver.domain.chat.services;

import com.team200.codeconnectedserver.domain.chat.exceptions.ChatNotFoundException;
import com.team200.codeconnectedserver.domain.chat.model.Chat;
import com.team200.codeconnectedserver.domain.message.model.Message;
import com.team200.codeconnectedserver.domain.profile.model.Profile;

import java.util.Date;
import java.util.List;

public interface ChatService {
    Chat create();

    Chat getById(Long chatId);

    Iterable<Chat> getByDate(Date date);

    void delete(Long id);
}
