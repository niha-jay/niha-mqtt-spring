package com.niha.spring.mqtt.utils;

import org.boon.json.JsonFactory;
import org.boon.json.ObjectMapper;

public enum JSON {

    MAPPER;

    private ObjectMapper mapper = JsonFactory.create();

    public byte[] toBytes(Object object) {
        return mapper.writeValueAsBytes(object);
    }

    public Object toObject(byte[] payload, Class type) {
        return mapper.readValue(payload, type);
    }
}
