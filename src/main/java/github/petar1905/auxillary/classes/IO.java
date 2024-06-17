package github.petar1905.auxillary.classes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class IO {
    private static IO singleInstance = null;
    private IO() {}

    public String readFile(String path) {
        InputStream stream = IO.class.getClassLoader().getResourceAsStream(path);
        InputStreamReader isr = new InputStreamReader(stream);
        BufferedReader buffer = new BufferedReader(isr);
        StringBuilder result = new StringBuilder();
        String line;
        try {
            while ((line = buffer.readLine()) != null) {
                result.append(line+" ");
            }
            buffer.close();
            isr.close();
            stream.close();
        } catch (IOException e) {
        }
        return result.toString();
    }

    public static synchronized IO getInstance() {
        if (singleInstance == null) {
            singleInstance = new IO();
        }
        return singleInstance;
    }
}
