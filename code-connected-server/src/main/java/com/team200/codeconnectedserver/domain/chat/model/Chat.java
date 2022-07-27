package com.team200.codeconnectedserver.domain.chat.model;

<<<<<<< HEAD
=======
import com.team200.codeconnectedserver.domain.message.model.Message;

>>>>>>> 9a4ba94dfb01c06ea4f74216e27053f42aa3e642
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import com.team200.codeconnectedserver.domain.message.model.Message;

<<<<<<< HEAD

import javax.persistence.*;
import java.util.Date;
=======
import javax.persistence.*;
import java.util.Date;

import lombok.*;


>>>>>>> 9a4ba94dfb01c06ea4f74216e27053f42aa3e642
import java.util.List;

import lombok.*;

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

>>>>>>> 9a4ba94dfb01c06ea4f74216e27053f42aa3e642
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @PrePersist
    protected void onCreate(){
        date = new Date();
    }
<<<<<<< HEAD
=======

>>>>>>> 9a4ba94dfb01c06ea4f74216e27053f42aa3e642
}
