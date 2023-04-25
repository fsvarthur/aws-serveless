package com.example.awsfunction.domain.gateway;

import com.example.awsfunction.domain.model.PersistNoteRequest;

public interface ReadSqsMessageBody {
    PersistNoteRequest read(String body);
}
