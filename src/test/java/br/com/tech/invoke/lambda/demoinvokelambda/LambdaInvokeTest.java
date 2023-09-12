package br.com.tech.invoke.lambda.demoinvokelambda;

import br.com.tech.invoke.lambda.demoinvokelambda.invoke.LambdaInvoke;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.services.lambda.AWSLambda;
import com.amazonaws.services.lambda.AWSLambdaClient;
import com.amazonaws.services.lambda.model.InvokeResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class LambdaInvokeTest {

    @Spy
    @InjectMocks
    private LambdaInvoke lambdaInvoke;

    @Mock
    private AWSCredentialsProvider provider;

    @Mock
    private AWSLambdaClient lambdaClient;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testarLambda() {
        AWSLambda awsLambda = Mockito.mock(AWSLambda.class);
        when(this.lambdaInvoke.criarAWSLambdaClient()).thenReturn(awsLambda);
        InvokeResult invokeResult = new InvokeResult();
        invokeResult.setStatusCode(200);
        when(awsLambda.invoke(any())).thenReturn(invokeResult);
        this.lambdaInvoke.invoke();
    }
}
