package github.petar1905.auxillary.classes;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Database {
    private static Database singleInstance = null;
    public Connection connection;

    private Database() throws SQLException {
        try {
            String host = System.getenv("HOST");
            if (host == null) host = AppProperties.getInstance().getProperty("host", "127.0.0.1");
            String user = System.getenv("USER");
            if (user == null) user = AppProperties.getInstance().getProperty("user", "root");
            String password = System.getenv("PASSWORD");
            if (password == null) password = AppProperties.getInstance().getProperty("password", "");
            String url = String.format("jdbc:mariadb://%s:3306/democritus?user=%s&password=%s", host, user, password);
            connection = DriverManager.getConnection(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static synchronized Database getInstance() throws SQLException {
        if (singleInstance == null) {
            singleInstance = new Database();
        }
        return singleInstance;
    }

    private void executeUpdate(String queryPath) throws SQLException, IOException {
        String baseDirectory = "sql/queries/database_init";
        queryPath = String.format("%s/%s", baseDirectory, queryPath);
        String query = IO.getInstance().readFile(queryPath);
        PreparedStatement ps = getInstance().connection.prepareStatement(query);
        ps.executeUpdate();
    }

    public void initializeDatabase() throws SQLException, IOException {
        executeUpdate("create_user_table.sql");
        executeUpdate("create_user_name_index.sql");
        executeUpdate("create_user_details_table.sql");
        executeUpdate("create_media_table.sql");
        executeUpdate("create_media_details_table.sql");
        executeUpdate("create_quantity_trigger.sql");
        executeUpdate("create_rent_table.sql");
        executeUpdate("create_rent_decrement_trigger.sql");
        executeUpdate("create_rent_increment_trigger.sql");
    }
}
