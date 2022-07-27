package com.team200.codeconnectedserver.domain.message.service;

import com.team200.codeconnectedserver.domain.chat.exceptions.ChatNotFoundException;
import com.team200.codeconnectedserver.domain.chat.model.Chat;
import com.team200.codeconnectedserver.domain.core.exceptions.ResourceNotFoundException;
import com.team200.codeconnectedserver.domain.message.model.Message;
import com.team200.codeconnectedserver.domain.message.repo.MessageRepo;
import com.team200.codeconnectedserver.domain.message.service.MessageService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class MessageServiceTest {
    @Autowired
    MessageService messageService;
    @MockBean
    MessageRepo messageRepo;

    private Message mockMessage;
    private Message savedMessage1;
    private Message savedMessage2;
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
        savedMessage2 = new Message(new Date(), 1L, "changed message");
        savedMessage2.setChat(chat);
        savedMessage2.setId(3L);
    }

    @Test
    public void createMessageTest() throws ChatNotFoundException {
        BDDMockito.doReturn(savedMessage1).when(messageRepo).save(mockMessage);
        Message actualMessage = messageService.create(mockMessage, 2L);
        Assertions.assertEquals(savedMessage1, actualMessage);
    }

    @Test
    public void getByIdTest01() {
        BDDMockito.doReturn(savedMessage1).when(messageRepo).save(mockMessage);
        BDDMockito.doReturn(Optional.of(savedMessage1)).when(messageRepo).findById(3L);
        Message actualMessage = messageService.getById(3L);
        Assertions.assertEquals(savedMessage1, actualMessage);
    }
    @Test
    public void getByIdTest02() {
        BDDMockito.doReturn(Optional.empty()).when(messageRepo).findById(3L);
        Assertions.assertThrows(ResourceNotFoundException.class, () -> {
            messageService.getById(3L);
        });
    }

    @Test
    public void getAllFromChatTest() {
        List<Message> mockMessageList = new ArrayList<>();
        mockMessageList.add(savedMessage1);
        BDDMockito.doReturn(mockMessageList).when(messageRepo).findByChat(chat);
        List<Message> actualMessageList = (List<Message>) messageService.getAllFromChat(chat);
        Assertions.assertEquals(mockMessageList, actualMessageList);
    }
    @Test
    public void getAllBySenderIdTest() {
        List<Message> mockMessageList = new ArrayList<>();
        mockMessageList.add(savedMessage1);
        BDDMockito.doReturn(mockMessageList).when(messageRepo).findBySenderId(1L);
        List<Message> actualMessageList = (List<Message>) messageService.getAllBySenderId(1L);
        Assertions.assertEquals(mockMessageList, actualMessageList);
    }

    @Test
    public void updateMessageTest() {
        BDDMockito.doReturn(Optional.of(savedMessage1)).when(messageRepo).findById(3L);
        BDDMockito.doReturn(savedMessage2).when(messageRepo).save(savedMessage1);
        Message actualMessage = messageService.update(3L, savedMessage2);
        String expectedContent = savedMessage2.getContent();
        String actualContent = actualMessage.getContent();
        Assertions.assertEquals(expectedContent, actualContent);
    }
}
