import com.google.gson.Gson;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;


public class FileService {

    public static Truck[] readFileTrucks() {
        Gson gson = new Gson();
        Path path = Paths.get("./baza.json");
        String json;
        try {
            json = Files.readString(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return gson.fromJson(json, Truck[].class);
    }

    public static Driver[] readFileDriver() {
        Gson gson = new Gson();
        Path path = Paths.get("./Driver.json");
        String json;
        try {
            json = Files.readString(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return gson.fromJson(json, Driver[].class);
    }

    public static int tryGetInteger(String value) {
        java.util.Scanner sc = new Scanner(System.in);
        try {
            System.out.printf("Enter %s: ", value);
            int num = Integer.parseInt(sc.nextLine());
            return num;
        } catch (NumberFormatException e) {
            System.err.println("incorrect value");
            return tryGetInteger("correct value");
        }catch (ArrayIndexOutOfBoundsException e){
            System.err.println("incorrect value");
            return tryGetInteger("correct value");
        }
    }

    public static void writeFile(Truck[] tracks) {
        Gson gson = new Gson();
        String json = gson.toJson(tracks);
        Path path = Paths.get("./baza.json");

        byte[] arr = json.getBytes();
        try {
            Files.write(path, arr);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
