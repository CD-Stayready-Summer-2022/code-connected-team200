package com.team200.codeconnectedserver.domain.chat.model;

import com.team200.codeconnectedserver.domain.message.model.Message;
<<<<<<< HEAD
import com.team200.codeconnectedserver.domain.profile.model.Profile;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
=======
import lombok.Data;
import lombok.NoArgsConstructor;
>>>>>>> cc819337eff7c6c686550422bc270564c5561874

import javax.persistence.*;
import java.util.Date;

<<<<<<< HEAD
=======

import lombok.*;
>>>>>>> cc819337eff7c6c686550422bc270564c5561874
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
=======


>>>>>>> cc819337eff7c6c686550422bc270564c5561874
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @PrePersist
    protected void onCreate(){
        date = new Date();
    }

}
