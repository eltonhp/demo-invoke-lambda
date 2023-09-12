package br.com.tech.invoke.lambda.demoinvokelambda.avro;

import example.avro.User;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.io.BinaryEncoder;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.specific.SpecificDatumWriter;

import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;

public class SerializaAvro {

    public void serializar(User user) {
        DatumWriter<User> userDatumWriter = new SpecificDatumWriter<User>(User.class);
        DataFileWriter<User> dataFileWriter = new DataFileWriter<User>(userDatumWriter);

        try {
            dataFileWriter.create(user.getSchema(), new File("users.avro"));
            dataFileWriter.append(user);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            dataFileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
