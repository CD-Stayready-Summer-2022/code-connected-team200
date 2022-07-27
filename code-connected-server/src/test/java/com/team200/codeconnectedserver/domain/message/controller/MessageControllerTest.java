package com.team200.codeconnectedserver.domain.message.controller;

import com.team200.codeconnectedserver.domain.chat.model.Chat;
import com.team200.codeconnectedserver.domain.exceptions.ResourceNotFoundException;
import com.team200.codeconnectedserver.domain.message.contoller.MessageController;
import com.team200.codeconnectedserver.domain.message.model.Message;
import com.team200.codeconnectedserver.domain.message.service.MessageService;
import com.team200.codeconnectedserver.security.models.FireBaseUser;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import security.PrincipalDetailsArgumentResolver;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.team200.codeconnectedserver.BaseControllerTest.asJsonString;
import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
public class MessageControllerTest {
//    @Autowired
    MockMvc mockMvc;

    @MockBean
    MessageService messageService;

    private Message mockMessage;
    private Message savedMessage1;
    private Message savedMessage2;
    private Message savedMessage3;
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
        savedMessage3 = new Message(new Date(), 1L, "changed message");
        savedMessage3.setChat(chat);
        savedMessage3.setId(4L);

        FireBaseUser fireBaseUser = new FireBaseUser();
        fireBaseUser.setEmail("test@user.com");
        fireBaseUser.setUid("xyz");
        mockMvc = MockMvcBuilders
                .standaloneSetup(new MessageController(messageService))
                .setCustomArgumentResolvers(new PrincipalDetailsArgumentResolver(fireBaseUser))
                .build();
    }

    @Test
    @DisplayName("POST /{id} - success")
    public void createMessageTest01() throws Exception {
        BDDMockito.doReturn(savedMessage1).when(messageService).create(any(), any());
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v2/messages/{id}", 2L)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(mockMessage)))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Is.is(3)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.senderId", Is.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.content", Is.is("first message")));
    }

    @Test
    @DisplayName("GET /message/{id} - success")
    public void getMessageByIdTest01() throws Exception {
        Long chatId = 2L;
        BDDMockito.doReturn(savedMessage1).when(messageService).getById(any());
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v2/messages/message/{id}", 3L)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Is.is(3)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.senderId", Is.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.content", Is.is("first message")));

    }

    @Test
    @DisplayName("GET /message/{id} - fail")
    public void getMessageByIdTest02() throws Exception {
        BDDMockito.doThrow(new ResourceNotFoundException("Message Does Not Exist")).when(messageService).getById(any());
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v2/messages/message/{id}", 3L)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    @DisplayName("GET /by-sender/{id} - success")
    public void getBySenderId() throws Exception {
        List<Message> messages = new ArrayList<>();
        messages.add(savedMessage1);
        messages.add(savedMessage3);
        BDDMockito.doReturn(messages).when(messageService).getAllBySenderId(1L);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v2/messages/by-sender/{id}",1)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    @DisplayName("Put /{id} - success")
    public void updateMessageTest01() throws Exception {
        BDDMockito.doReturn(savedMessage2).when(messageService).update(any(), any());
        mockMvc.perform(MockMvcRequestBuilders.put("/api/v2/messages/{id}", 3)
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(savedMessage2)))
                .andExpect(MockMvcResultMatchers.status().isAccepted())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Is.is(3)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.content", Is.is("changed message")));
    }

    @Test
    @DisplayName("Put /{id} - fail")
    public void updateMessageTest02() throws Exception {
        BDDMockito.doThrow(new ResourceNotFoundException("Message Does Not Exist")).when(messageService).update(any(), any());
        mockMvc.perform(MockMvcRequestBuilders.put("/api/v2/messages/{id}", 3)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(savedMessage2)))
                .andExpect(MockMvcResultMatchers.status().isNotFound());

    }

    @Test
    @DisplayName("DELETE /message/{id} - Success")
    public void deleteMessageTest01() throws Exception{
        BDDMockito.doReturn(true).when(messageService).delete(any());
        mockMvc.perform(delete("/api/v2/messages/message/{id}", 3L))
                .andExpect(status().isNoContent());
    }

    @Test
    @DisplayName("DELETE /message/{id} - fail")
    public void deleteMessageTest02() throws Exception{
        BDDMockito.doThrow(new ResourceNotFoundException("Message Does Not Exist")).when(messageService).delete(any());
        mockMvc.perform(delete("/api/v2/messages/message/{id}", 3L))
                .andExpect(status().isNotFound());
    }
}


