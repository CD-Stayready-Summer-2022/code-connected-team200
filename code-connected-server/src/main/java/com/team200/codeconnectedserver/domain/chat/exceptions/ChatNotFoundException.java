package com.team200.codeconnectedserver.domain.chat.exceptions;

public class ChatNotFoundException extends Exception{
    public ChatNotFoundException(String message) {
        super(message);
    }

    public ChatNotFoundException(Throwable cause) {
        super(cause);
    }
}
