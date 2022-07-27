package com.team200.codeconnectedserver.domain.chat.services;

import com.team200.codeconnectedserver.domain.chat.exceptions.ChatNotFoundException;
import com.team200.codeconnectedserver.domain.chat.model.Chat;
import com.team200.codeconnectedserver.domain.chat.repo.ChatRepo;
import com.team200.codeconnectedserver.domain.core.exceptions.ResourceNotFoundException;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
@Slf4j
public class ChatServiceImpl implements ChatService {

    private ChatRepo chatRepo;

    @Autowired
    public ChatServiceImpl(ChatRepo chatRepo) {
        this.chatRepo = chatRepo;
    }

    @Override
    public Chat create() {
        Chat chat = new Chat();
        chatRepo.save(chat);
        return chat;
    }

    @Override
    public Chat getById(Long chatId) {
        Optional<Chat> optional = chatRepo.findById(chatId);
        if (optional.isPresent())
            throw new ResourceNotFoundException("Chat Does Not Exist");
        return optional.get();
    }

    @Override
    public Iterable<Chat> getByDate(Date date){
        return chatRepo.findByDate(date);
    }

    @Override
    public void delete(Long id) {
        Optional<Chat> optional = chatRepo.findById(id);
        if (optional.isPresent())
            throw new ResourceNotFoundException("Chat Does Not Exist");
        chatRepo.delete(optional.get());
    }
}