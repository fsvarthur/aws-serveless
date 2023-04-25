package com.example.awsfunction.config;

import com.example.awsfunction.domain.ProcessNoteRequest;
import com.example.awsfunction.domain.gateway.ReadSqsMessageBody;
import com.example.awsfunction.domain.gateway.SaveNoteRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {

    @Bean
    public ProcessNoteRequest processNoteRequest(
            ReadSqsMessageBody readSqsMessageBody, SaveNoteRequest saveNoteRequest){
        return new ProcessNoteRequest(readSqsMessageBody, saveNoteRequest);
    }
}
