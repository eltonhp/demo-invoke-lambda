package br.com.tech.invoke.lambda.demoinvokelambda;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Configuration
@Profile("!local")
public class AWSCloudConfig implements AWSConfig {

    @Bean
    AWSCredentialsProvider getCredentials() {
        return DefaultAWSCredentialsProviderChain.getInstance();
    }
}
