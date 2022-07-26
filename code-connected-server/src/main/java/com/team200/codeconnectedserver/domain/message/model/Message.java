package com.team200.codeconnectedserver.domain.message.model;

import com.sun.istack.NotNull;
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
<<<<<<< HEAD
    private Chat chat;

=======
    Chat chat;
>>>>>>> 5c43849cffd951cd0e35514b76a5702d1cacd168
    @PrePersist
    protected void onCreate() {
        date = new Date();
    }
}

