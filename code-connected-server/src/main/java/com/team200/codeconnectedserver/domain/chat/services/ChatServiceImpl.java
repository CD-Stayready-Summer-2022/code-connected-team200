package com.team200.codeconnectedserver.domain.chat.services;

import com.team200.codeconnectedserver.domain.chat.exceptions.ChatNotFoundException;
import com.team200.codeconnectedserver.domain.chat.model.Chat;
import com.team200.codeconnectedserver.domain.chat.repo.ChatRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ChatServiceImpl implements ChatService{

    private ChatRepo chatRepo;

    @Autowired
    public ChatServiceImpl(ChatRepo chatRepo) {
        this.chatRepo = chatRepo;
    }

    @Override
    public Chat create(Profile person1, Profile person2) {
        Chat chat = new Chat();
        chat.setProfile1(person1);
        chat.setProfile1(person2);
        chatRepo.save(chat);
        return chat;
    }

    @Override
    public Chat getById(Long chatId) throws ChatNotFoundException {
        Chat chat = chatRepo.findById(chatId)
                .orElseThrow(()->new ChatNotFoundException("No Chat with id: " + chatId));
        return chat;
    }

    @Override
    public Chat getByProfiles(Profile person1, Profile person2) throws ChatNotFoundException {
        if(hasSharedChat(person1, person2)){
            Iterable<Chat> possibleChats = (Iterable<Chat>) chatRepo.findByProfile(person1);
            for(Chat possibleChat: possibleChats){
                if(profileHasSpecificChat(person2, possibleChat)){
                    return possibleChat;
                }
            }
        }else{
            throw new ChatNotFoundException("No shared chat between profile id = " = person1.getId() + " and profile id = " + person2.getId());
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
        return possibleChats;
    }

    @Override
    public Boolean profileHasSpecificChat(Profile person, Chat chat){
        Iterable<Chat> possibleChats = (Iterable<Chat>) chatRepo.findByProfile(person);
        for (Chat possibleChat : possibleChats) {
            if(possibleChat.getId() == chat.getId()){
                return true;
            }
        }
        return false;
    }

    @Override
    public Boolean hasChats(Profile person){
        Iterable<Chat> possibleChats = (Iterable<Chat>) chatRepo.findByProfile(person);
        int count = 0;
        for (Chat possibleChat : possibleChats) {
            count++;
        }
        return count>0;
    }

    @Override
    public Boolean hasSharedChat(Profile person1, Profile person2){
        Iterable<Chat> possibleChats = (Iterable<Chat>) chatRepo.findByProfile(person1);
        for(Chat possibleChat: possibleChats){
            if(profileHasSpecificChat(person2, possibleChat)){
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Chat> getAll(){
        return chatRepo.findAll();
    }

}
