package com.example.awsfunction.config;

import com.example.awsfunction.domain.model.PersistNoteRequest;
import com.example.awsfunction.entrypoint.model.SqsEvent;
import com.example.awsfunction.entrypoint.model.SqsMessage;
import com.example.awsfunction.gateway.dynamodb.model.Note;
import org.springframework.aot.hint.annotation.RegisterReflectionForBinding;
import org.springframework.context.annotation.Configuration;

@Configuration
@RegisterReflectionForBinding({
        PersistNoteRequest.class,
        SqsMessage.class,
        SqsEvent.class,
        Note.class
})
public class NativeConfig {
}
