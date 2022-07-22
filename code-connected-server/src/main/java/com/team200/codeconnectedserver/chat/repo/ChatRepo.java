package com.team200.codeconnectedserver.chat.repo;

import com.team200.codeconnectedserver.chat.model.Chat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRepo extends JpaRepository <Chat, Long>  {
    Chat findByProfile(Profile profile1);
}
