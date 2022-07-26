package com.team200.codeconnectedserver.domain.chat.repo;

import com.team200.codeconnectedserver.domain.chat.model.Chat;
import com.team200.codeconnectedserver.domain.profile.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

<<<<<<< HEAD
import java.util.Date;

public interface ChatRepo extends JpaRepository <Chat, Long>  {
    Iterable<Chat> findByDate(Date date);
=======
public interface ChatRepo extends JpaRepository<Chat, Long> {
    Chat findByProfile(Profile person1);
>>>>>>> 5c43849cffd951cd0e35514b76a5702d1cacd168
}
