package com.example.awsfunction.entrypoint.model;

import java.util.List;

public record SqsEvent(List<SqsMessage> records) { }
