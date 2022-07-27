package com.team200.codeconnectedserver.domain.message.repo;

import com.team200.codeconnectedserver.domain.chat.model.Chat;
import com.team200.codeconnectedserver.domain.message.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MessageRepo extends JpaRepository<Message, Long> {
    Iterable<Message> findBySenderId(Long id);
    List<Message> findByChat(Chat chat);
}
