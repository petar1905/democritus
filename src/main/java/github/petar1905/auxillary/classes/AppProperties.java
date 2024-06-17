package github.petar1905.auxillary.classes;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AppProperties {
    private static AppProperties singleInstance = null;
    private String propsPath = "src/main/resources/app/app.properties";
    private Properties props;

    private AppProperties() throws IOException {
        props = new Properties(3);
        File propsFile = new File(propsPath);
        if (!propsFile.exists()) propsFile.createNewFile();
        InputStream stream = IO.class.getClassLoader().getResourceAsStream("app/app.properties");
        props.load(stream);
    }

    public static synchronized AppProperties getInstance() {
        if (singleInstance == null) {
            try {
                singleInstance = new AppProperties();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return singleInstance;
    }

    public String getProperty(String key, String defaultValue) {
        return props.getProperty(key, defaultValue);
    }
    public void setProperty(String key, String value) throws IOException {
        this.props.setProperty(key, value);
        this.props.store(new FileWriter(propsPath), "hi");

    }
}
