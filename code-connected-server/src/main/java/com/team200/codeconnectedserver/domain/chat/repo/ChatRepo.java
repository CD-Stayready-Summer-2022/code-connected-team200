package com.team200.codeconnectedserver.domain.chat.repo;

import com.team200.codeconnectedserver.domain.chat.model.Chat;
import com.team200.codeconnectedserver.domain.profile.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRepo extends JpaRepository<Chat, Long> {
    Chat findByProfile(Profile person1);
}
