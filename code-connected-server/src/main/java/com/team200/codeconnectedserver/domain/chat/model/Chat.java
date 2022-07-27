package com.team200.codeconnectedserver.domain.chat.model;

import com.team200.codeconnectedserver.domain.message.model.Message;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;


import lombok.*;
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


    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @PrePersist
    protected void onCreate(){
        date = new Date();
    }

}
