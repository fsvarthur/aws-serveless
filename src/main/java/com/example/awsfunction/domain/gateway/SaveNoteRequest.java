package com.example.awsfunction.domain.gateway;

import com.example.awsfunction.domain.model.PersistNoteRequest;

public interface SaveNoteRequest {
    void save(PersistNoteRequest request);
}
