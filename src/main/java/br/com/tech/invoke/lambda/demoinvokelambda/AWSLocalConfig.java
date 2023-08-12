package br.com.tech.invoke.lambda.demoinvokelambda;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Configuration
@Profile("local")
public class AWSLocalConfig implements AWSConfig {

    @Bean
    AWSCredentialsProvider getCredentials() {
        String accessKey = System.getenv("SUA_ACCESS_KEY");
        String secretKey = System.getenv("SUA_SECRET_KEY");
        String region = "us-east-1"; // Substitua pela região correta

        // Configurar credenciais e cliente do AWS Lambda
        BasicAWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);
        return new AWSStaticCredentialsProvider(credentials);
    }
}
