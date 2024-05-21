package github.petar1905.auxillary.classes;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static Database singleInstance = null;
    public Connection connection;

    private Database() throws SQLException {
        String host = System.getenv("HOST");
        String user = System.getenv("USER");
        String password = System.getenv("PASSWORD");
        String url = String.format("jdbc:mariadb://%s:3306/democritus?user=%s&password=%s", host, user, password);
        connection = DriverManager.getConnection(url);
        //connection = DriverManager.getConnection(host, user, password);
    }

    public static synchronized Database getInstance() throws SQLException {
        if (singleInstance == null) {
            singleInstance = new Database();
        }
        return singleInstance;
    }

    // TODO: Create methods for initializing database
}
