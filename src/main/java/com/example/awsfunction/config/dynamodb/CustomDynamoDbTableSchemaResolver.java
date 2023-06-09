package com.example.awsfunction.config.dynamodb;

import io.awspring.cloud.dynamodb.DynamoDbTableNameResolver;
import io.awspring.cloud.dynamodb.DynamoDbTableSchemaResolver;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CustomDynamoDbTableSchemaResolver implements DynamoDbTableSchemaResolver {
private final Map<String, TableSchema<?>> tableSchemaMap = new ConcurrentHashMap<>();

    @Override
    public <T> TableSchema resolve(Class<T> clazz, String tableName) {
        return tableSchemaMap.get(tableName);
    }

    public void prefillCache(DynamoDbTableNameResolver resolver, List<TableSchema<?>> tableSchemas){
        tableSchemas.forEach(
                it -> {
                    var key = resolver.resolve(it.itemType().rawClass());
                    tableSchemaMap.put(key, it);
                } );
    }
}
