package github.petar1905.auxillary.classes;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static Database singleInstance = null;
    public Connection connection;

    private Database() throws SQLException {
        connection = DriverManager.getConnection(null, null, null);
        // TODO: Add settings that can be passed as commandline parameters
    }

    public static synchronized Database getInstance() throws SQLException {
        if (singleInstance == null) {
            singleInstance = new Database();
        }
        return singleInstance;
    }

    // TODO: Create methods for initializing database
}
