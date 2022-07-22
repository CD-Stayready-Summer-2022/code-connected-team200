package com.team200.codeconnectedserver.domain.chat.services;

import com.team200.codeconnectedserver.domain.chat.exceptions.ChatNotFoundException;
import com.team200.codeconnectedserver.domain.chat.model.Chat;
import com.team200.codeconnectedserver.domain.profile.model.Profile;

import java.util.List;

public interface ChatService {
    Chat create(Profile person1, Profile person2);

    Chat getById(Long chatId) throws ChatNotFoundException;

    Chat getByProfiles(Profile person1, Profile person2) throws ChatNotFoundException;

    Iterable<Chat> getMultipleChatsByProfile(Profile person) throws ChatNotFoundException;

    Boolean profileHasSpecificChat(Profile person, Chat chat);

    Boolean hasChats(Profile person);

    Boolean hasSharedChat(Profile person1, Profile person2);

    List<Chat> getAll();


}
