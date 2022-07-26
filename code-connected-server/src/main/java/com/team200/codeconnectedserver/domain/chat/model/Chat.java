package com.team200.codeconnectedserver.domain.chat.model;

import com.team200.codeconnectedserver.domain.message.model.Message;
import com.team200.codeconnectedserver.domain.profile.model.Profile;
<<<<<<< HEAD
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Date;
=======
import lombok.*;

import javax.persistence.*;
>>>>>>> 5c43849cffd951cd0e35514b76a5702d1cacd168
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

<<<<<<< HEAD
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Message> messagesList;

    @PrePersist
    protected void onCreate(){
        date = new Date();
    }
=======
>>>>>>> 5c43849cffd951cd0e35514b76a5702d1cacd168
}
