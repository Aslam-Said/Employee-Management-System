package model.Connection;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import model.Employee;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class ConnectionUsers {
    private final Path databaseFile;
    private final ObjectMapper mapper;

    public ConnectionUsers() throws IOException {

        this.mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);

        Path folder = Path.of("data");

        this.databaseFile = folder.resolve("users.json");

        if(Files.notExists(databaseFile)){
            write(new ArrayList<>());
        }

    }
    public ArrayList<Account> read() throws IOException {
        if (Files.notExists(databaseFile) || Files.size(databaseFile) == 0) {
            return new ArrayList<>();
        }
        return mapper.readValue(databaseFile.toFile(), new TypeReference<ArrayList<Account>>() {});
    }

    public void write(ArrayList<Account> users) throws IOException {
        mapper.writeValue(databaseFile.toFile(), users);
    }
}
