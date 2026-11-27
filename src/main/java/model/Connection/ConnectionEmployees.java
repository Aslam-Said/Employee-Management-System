package model.Connection;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import model.Employee;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class Connection {
    private final Path databaseFile;
    private final ObjectMapper mapper;

    public Connection(String Filename) throws IOException {

        this.mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);

        Path folder = Path.of("data");

        this.databaseFile = folder.resolve(Filename+".json");

        if(Files.notExists(databaseFile)){
            write(new ArrayList<>());
        }

    }

    public ArrayList<Employee> readEmployees() throws IOException {
        if (Files.notExists(databaseFile) || Files.size(databaseFile) == 0) {
            return new ArrayList<>();
        }
        return mapper.readValue(databaseFile.toFile(), new TypeReference<ArrayList<Employee>>() {});
    }

    public ArrayList<Account> readUsers()throws IOException{
        if (Files.notExists(databaseFile) || Files.size(databaseFile) == 0) {
            return new ArrayList<>();
        }

        return mapper.readValue(databaseFile.toFile(), new TypeReference<ArrayList<Account>>() {});
    }

    public void write(ArrayList<Employee> employees) throws IOException {
        mapper.writeValue(databaseFile.toFile(), employees);
    }

}