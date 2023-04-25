package com.example.awsfunction.gateway.dynamodb.transformer;

public interface RequestTransformer<I, O> {
    O transform(I input);
}
