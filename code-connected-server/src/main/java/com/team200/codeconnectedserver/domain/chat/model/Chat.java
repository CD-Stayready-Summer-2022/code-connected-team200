package com.team200.codeconnectedserver.domain.chat.model;

import com.team200.codeconnectedserver.domain.message.model.Message;
import com.team200.codeconnectedserver.domain.profile.model.Profile;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity(name = "chats")
@Data
@NoArgsConstructor
@ToString
public class Chat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    //chagne to profile object when it becomes available
    @OneToMany(cascade = CascadeType.ALL)
    private List<Message> messages;

}
