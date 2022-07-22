package com.team200.codeconnectedserver.domain.message.service;

import com.team200.codeconnectedserver.domain.chat.model.Chat;
import com.team200.codeconnectedserver.domain.message.model.Message;
import com.team200.codeconnectedserver.domain.message.repo.MessageRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.persistence.Temporal;
import java.util.Date;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class MessageServiceTest {
    @Autowired
    MessageService messageService;
    @MockBean
    MessageRepo messageRepo;

    private Message mockMessage;
    private Message savedMessage1;
    private Message getSavedMessage2;
    private Chat chat;
    @BeforeEach
    public void setUp() {
        chat = new Chat();
        chat.setId(2L);
        mockMessage = new Message(new Date(), 1L, "first message");
        mockMessage.setChat(chat);
        savedMessage1 = new Message(new Date(), 1L, "first message");
        savedMessage1.setChat(chat);
        savedMessage1.setId(3L);
        mockMessage = new Message(new Date(), 1L, "changed message");
        savedMessage1.setChat(chat);
        savedMessage1.setId(3L);
    }

    @Test
    public void createMessageTest() {
        BDDMockito.doReturn(savedMessage1).when(messageRepo).save(mockMessage);
        Message actualMessage = messageService.create(mockMessage, chat);
        Assertions.assertTrue(savedMessage1.equals(actualMessage));
    }
}
