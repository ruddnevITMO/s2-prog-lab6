package ru.rudXson.base;
import com.google.gson.Gson;
import ru.rudXson.datatype.Flat;

import javax.naming.NoPermissionException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.PriorityQueue;


public class Serializer {
    public static void serialize(PriorityQueue<Flat> flats, String fileName) throws IOException, NoPermissionException {
        Path path = Paths.get(fileName);
        if (!path.isAbsolute()) path = path.toAbsolutePath();
        if (!Files.isRegularFile(path)) throw new IOException("Not a file!");
        if (!Files.isWritable(path)) throw new NoPermissionException("File isn't writable!");
        if (!Files.isReadable(path)) throw new NoPermissionException("File isn't readable!");
        Gson gson = new Gson();
        try(BufferedWriter buf = new BufferedWriter(new FileWriter(fileName))){
            gson.toJson(flats, buf);
        }
    }
}
