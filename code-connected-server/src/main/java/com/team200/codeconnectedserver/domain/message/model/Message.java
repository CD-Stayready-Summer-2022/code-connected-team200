package com.team200.codeconnectedserver.domain.message.model;

import com.team200.codeconnectedserver.domain.chat.model.Chat;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "messages")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @NonNull
    private Long senderId;
    @NonNull
    private String content;
    @ManyToOne
    Chat chat;
    @PrePersist
    protected void onCreate() {
        date = new Date();
    }
}

