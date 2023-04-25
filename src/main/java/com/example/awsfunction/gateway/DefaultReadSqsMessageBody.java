package com.example.awsfunction.gateway;

import com.example.awsfunction.domain.gateway.ReadSqsMessageBody;
import com.example.awsfunction.domain.model.PersistNoteRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DefaultReadSqsMessageBody implements ReadSqsMessageBody {
    private static final Logger LOG = LoggerFactory.getLogger(DefaultReadSqsMessageBody.class);

    private final ObjectMapper objectMapper;

    public DefaultReadSqsMessageBody(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public PersistNoteRequest read(String body){
        try{
            return objectMapper.readValue(body, PersistNoteRequest.class);
        }catch (JsonProcessingException exception){
            LOG.error("Failed to read value: {}", body, exception);
            throw new RuntimeException("Failed to process json");
        }
    }
}
