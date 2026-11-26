package model.Connection;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class Connection {
    private Gson gson=new GsonBuilder().setPrettyPrinting().create();
    Path path= Path.of("data");
    Path Employeefile ;
    public Connection(String dir){          //if we do the a lot of the file
        Employeefile=path.resolve(dir+".jason");
    }
    public Employee[] Load()throws IOException{
        if(Files.notExists(Employeefile)){
            System.out.println("THE FILE IS NOT EXIST");
            return new Employee[0];
        }
        String content=Files.readString(Employeefile,StandardCharsets.UTF_8).trim();
        if(content.isEmpty()){
            System.out.println("THE FILE IS EMPTY");
            return new Employee[0];
        }
        Employee[] loaded=gson.fromJson(content,Employee[].class);
        return loaded;

    }
    public Boolean save(Employee[] employees)throws IOException{
        if(Files.notExists(Employeefile)){
            Files.createDirectories(Employeefile.getParent());
        }
        String jason=gson.toJson(employees);
        Files.writeString(Employeefile,jason,StandardCharsets.UTF_8);
        return true;

    }
}