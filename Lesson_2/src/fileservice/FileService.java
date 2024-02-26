package fileservice;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileService {
    String FILEPATH = "src/log.txt";


    public void saveLog(String message){
        try (FileWriter writer = new FileWriter(FILEPATH, true)){
            writer.write(message);
            writer.write("\n");
            writer.flush();
        } catch (IOException e){
            e.getMessage();
        }
    }

    public String loadLog(){
        File file = new File(FILEPATH);
        StringBuilder stringBuilder = new StringBuilder();
        try(Scanner scanner = new Scanner(file)){
            while (scanner.hasNext()){
                stringBuilder.append(scanner.nextLine()).append("\n");
            }
        } catch (FileNotFoundException e){
            e.getMessage();
        }
        return stringBuilder.toString();
    }
}
