package hadinaJmartRK;

import java.util.Collections;
import java.util.Vector;
import java.io.*;
import java.lang.reflect.Array;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;


public class JsonTable<T> extends Vector{
    public final String filepath;
    private static final Gson gson = new Gson();

    public JsonTable(Class<T> clazz, String filepath) throws IOException {
        this.filepath = filepath;
    }

    public static <T> JsonReader readJson(Class<T> clazz, String filepath) throws FileNotFoundException {
        T read = null;
        try {
            final JsonReader reader = new JsonReader(new FileReader(filepath));
            read = gson.fromJson(reader, clazz);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return (JsonReader) read;
    }

    public void writeJson() throws IOException {
        writeJson(this, this.filepath);
    }

    public static void writeJson(Object object, String filepath) throws IOException {
        try{
            FileWriter writer = new FileWriter(filepath);
            String json = gson.toJson(object);
            writer.write(json);
            writer.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}