package com.team200.codeconnectedserver.domain.blogpost;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonConverter {
    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}