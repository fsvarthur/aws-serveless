package com.example.awsfunction.gateway.dynamodb;

import com.example.awsfunction.domain.gateway.SaveNoteRequest;
import com.example.awsfunction.domain.model.PersistNoteRequest;
import com.example.awsfunction.gateway.dynamodb.model.Note;
import com.example.awsfunction.gateway.dynamodb.transformer.RequestTransformer;
import io.awspring.cloud.dynamodb.DynamoDbTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class DefaultSaveNoteRequest implements SaveNoteRequest {
    private final Logger LOG = LoggerFactory.getLogger(DefaultSaveNoteRequest.class);

    private final DynamoDbTemplate template;
    private final RequestTransformer<PersistNoteRequest, Note> transformer;

    public DefaultSaveNoteRequest(DynamoDbTemplate template, RequestTransformer<PersistNoteRequest, Note> transformer) {
        this.template = template;
        this.transformer = transformer;
    }

    @Override
    public void save(PersistNoteRequest persistNoteRequest){
        LOG.info("Persisting {}", persistNoteRequest);

        var dbEntry = transformer.transform(persistNoteRequest);
        template.save(dbEntry);
    }
}
