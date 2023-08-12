package br.com.tech.invoke.lambda.demoinvokelambda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DemoInvokeLambdaApplication {

	@Autowired
	LambdaInvoke lambdaInvoke;

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(DemoInvokeLambdaApplication.class, args);
		LambdaInvoke lambdaInvoke = context.getBean(LambdaInvoke.class);
		lambdaInvoke.invoke();
	}

}
