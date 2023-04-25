package com.example.awsfunction.entrypoint;

import com.example.awsfunction.domain.ProcessNoteRequest;
import com.example.awsfunction.entrypoint.model.SqsEvent;
import com.example.awsfunction.entrypoint.model.SqsMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
public class LambdaFunction implements Consumer<SqsEvent> {

    private static final Logger LOG = LoggerFactory.getLogger(LambdaFunction.class);

    private final ProcessNoteRequest processNoteRequest;

    public LambdaFunction(ProcessNoteRequest processNoteRequest) {
        this.processNoteRequest = processNoteRequest;
    }

    @Override
    public void accept(SqsEvent sqsEvent){
        LOG.info("Received event: {}", sqsEvent);

        sqsEvent.records()
                .stream()
                .map(SqsMessage::body)
                .forEach(processNoteRequest::process);
    }
}
