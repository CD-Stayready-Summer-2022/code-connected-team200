package com.team200.codeconnectedserver.domain.chat.services;

import com.team200.codeconnectedserver.domain.chat.model.Chat;
import com.team200.codeconnectedserver.domain.chat.repo.ChatRepo;
<<<<<<< HEAD
import com.team200.codeconnectedserver.domain.exceptions.ResourceNotFoundException;
=======
import com.team200.codeconnectedserver.domain.profile.model.Profile;
>>>>>>> 5c43849cffd951cd0e35514b76a5702d1cacd168
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
@Slf4j
public class ChatServiceImpl implements ChatService{

    private ChatRepo chatRepo;

    @Autowired
    public ChatServiceImpl(ChatRepo chatRepo) {
        this.chatRepo = chatRepo;
    }

    @Override
    public Chat create() {
        Chat chat = new Chat();
<<<<<<< HEAD
=======
      //  chat.setProfile1(person1);
        //chat.setProfile1(person2);
>>>>>>> 5c43849cffd951cd0e35514b76a5702d1cacd168
        chatRepo.save(chat);
        return chat;
    }

    @Override
    public Chat getById(Long chatId) {
        Optional<Chat> optional = chatRepo.findById(chatId);
        if(optional.isPresent())
            throw new ResourceNotFoundException("Chat Does Not Exist");
        return optional.get();
    }

    @Override
<<<<<<< HEAD
    public Iterable<Chat> getByDate(Date date){
        return chatRepo.findByDate(date);
    }

    @Override
    public void delete(Long id) {
        Optional<Chat> optional = chatRepo.findById(id);
        if(optional.isPresent())
            throw new ResourceNotFoundException("Chat Does Not Exist");
        chatRepo.delete(optional.get());
=======
    public Chat getByProfiles(Profile person1, Profile person2) throws ChatNotFoundException {
        if(hasSharedChat(person1, person2)){
            Iterable<Chat> possibleChats = (Iterable<Chat>) chatRepo.findByProfile(person1);
            for(Chat possibleChat: possibleChats){
                if(profileHasSpecificChat(person2, possibleChat)){
                    return possibleChat;
                }
            }
        }else{
            throw new ChatNotFoundException("No shared chat between profile id = " + person1.getId() + " and profile id = " + person2.getId());
        }
        return null;
    }

    @Override
    public Iterable<Chat> getMultipleChatsByProfile(Profile person) throws ChatNotFoundException{
        Iterable<Chat> possibleChats = null;
        if(hasChats(person)){
            return (Iterable<Chat>) chatRepo.findByProfile(person);
        }else{
            throw new ChatNotFoundException("Not chats found for Profile id: " + person.getId());
        }
>>>>>>> 5c43849cffd951cd0e35514b76a5702d1cacd168
    }


























}
