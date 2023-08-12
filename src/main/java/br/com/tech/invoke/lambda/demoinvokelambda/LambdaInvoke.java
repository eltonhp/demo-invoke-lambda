package br.com.tech.invoke.lambda.demoinvokelambda;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.lambda.AWSLambda;
import com.amazonaws.services.lambda.AWSLambdaClientBuilder;
import com.amazonaws.services.lambda.model.InvokeRequest;
import com.amazonaws.services.lambda.model.InvokeResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LambdaInvoke {

    @Autowired
    AWSCredentialsProvider provider;
    public void invoke() {
        String region = "us-east-1"; // Substitua pela região correta
        AWSLambda lambdaClient = AWSLambdaClientBuilder.standard()
                .withCredentials(provider)
                .withRegion(region)
                .build();



        // Nome da função Lambda a ser invocada
        String functionName = "HelloWord";

        // Configurar a solicitação de invocação
        InvokeRequest invokeRequest = new InvokeRequest()
                .withFunctionName(functionName)
                .withPayload("{ \"name\": \"Bob\" }"); // Payload vazio neste exemplo

        // Invocar a função Lambda
        InvokeResult invokeResult = lambdaClient.invoke(invokeRequest);

        // Processar a resposta
        String responsePayload = new String(invokeResult.getPayload().array());
        System.out.println("Resposta da função Lambda: " + responsePayload);
    }
}
