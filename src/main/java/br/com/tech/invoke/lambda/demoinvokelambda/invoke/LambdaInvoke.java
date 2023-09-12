package br.com.tech.invoke.lambda.demoinvokelambda.invoke;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.services.lambda.AWSLambda;
import com.amazonaws.services.lambda.AWSLambdaClientBuilder;
import com.amazonaws.services.lambda.model.InvokeRequest;
import com.amazonaws.services.lambda.model.InvokeResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LambdaInvoke {

    private final AWSCredentialsProvider provider;


    public AWSLambda criarAWSLambdaClient() {
        String region = "us-east-1"; // Substitua pela região correta
        AWSLambda lambdaClient = AWSLambdaClientBuilder.standard()
                .withCredentials(provider)
                .withRegion(region)
                .build();

        return lambdaClient;
    }

    public void invoke() {

        AWSLambda lambdaClient = criarAWSLambdaClient();



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
