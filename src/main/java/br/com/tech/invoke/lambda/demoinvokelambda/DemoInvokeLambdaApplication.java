package br.com.tech.invoke.lambda.demoinvokelambda;

import br.com.tech.invoke.lambda.demoinvokelambda.avro.DeserializaAvro;
import br.com.tech.invoke.lambda.demoinvokelambda.avro.SerializaAvro;
import br.com.tech.invoke.lambda.demoinvokelambda.invoke.LambdaInvoke;
import example.avro.User;
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
		User user = new User("Ben", 7, "red");
		SerializaAvro serializaAvro = new SerializaAvro();
		serializaAvro.serializar(user);
		DeserializaAvro deserializaAvro = new DeserializaAvro();
		deserializaAvro.deserializar(user);
		lambdaInvoke.invoke();
	}

}
