package com.example.awsfunction.domain;

import com.example.awsfunction.domain.gateway.ReadSqsMessageBody;
import com.example.awsfunction.domain.gateway.SaveNoteRequest;

public class ProcessNoteRequest {
    private final ReadSqsMessageBody readSqsMessageBody;
    private final SaveNoteRequest saveNoteRequest;

    public ProcessNoteRequest(ReadSqsMessageBody readSqsMessageBody, SaveNoteRequest saveNoteRequest) {
        this.readSqsMessageBody = readSqsMessageBody;
        this.saveNoteRequest = saveNoteRequest;
    }

    public void process(String messageBody){
        var result = readSqsMessageBody.read(messageBody);
        saveNoteRequest.save(result);
    }
}
