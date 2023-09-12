package br.com.tech.invoke.lambda.demoinvokelambda.avro;

import example.avro.User;
import org.apache.avro.file.DataFileReader;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.io.DatumReader;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.specific.SpecificDatumReader;
import org.apache.avro.specific.SpecificDatumWriter;

import java.io.File;
import java.io.IOException;

public class DeserializaAvro {

    public void deserializar(User user) {
        File file = new File("users.avro");
        DatumReader<User> userDatumReader = new SpecificDatumReader<User>(User.class);
        DataFileReader<User> dataFileReader = null;
        try {
            dataFileReader = new DataFileReader<User>(file, userDatumReader);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        while (dataFileReader.hasNext()) {
            try {
                user = dataFileReader.next(user);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            System.out.println(user);
        }
    }
}
