package com.team200.codeconnectedserver.domain.chat.repo;
import com.team200.codeconnectedserver.domain.chat.model.Chat;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Date;

public interface ChatRepo extends JpaRepository<Chat, Long> {
    Iterable<Chat> findByDate(Date date);
}
