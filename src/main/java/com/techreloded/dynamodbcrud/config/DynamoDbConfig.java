package com.techreloded.dynamodbcrud.config;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBAsyncClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.techreloded.dynamodbcrud.constants.Constants;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DynamoDbConfig {

    @Bean
    public DynamoDBMapper mapper(){
        return new DynamoDBMapper( awsDynamoDBConfig());
    }

    public AmazonDynamoDB awsDynamoDBConfig(){
        return AmazonDynamoDBClientBuilder.standard()
                .withEndpointConfiguration(
                        new AwsClientBuilder.EndpointConfiguration(
                                Constants.AWS_SERVICE_END_POINT,
                                Constants.AWS_REGION
                        )
                ).withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials(
                        Constants.AWS_ACCESS_KEY,
                        Constants.AWS_SECRET_KEY
                ))).build();

    }
}
