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
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        AppProperties props = AppProperties.getInstance();
        String host = props.getProperty("host", "127.0.0.1");
        String user = props.getProperty("user", "root");
        String password = props.getProperty("password", "");
        String url = String.format("jdbc:mariadb://%s:3306/democritus", host);
        connection = DriverManager.getConnection(url, user, password);
        connection.setAutoCommit(false);
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
        executeUpdate("create_user_delete_trigger.sql");
        executeUpdate("create_media_table.sql");
        executeUpdate("create_media_details_table.sql");
        executeUpdate("create_quantity_trigger.sql");
        executeUpdate("create_rent_table.sql");
        executeUpdate("create_rent_decrement_trigger.sql");
        executeUpdate("create_rent_increment_trigger.sql");
        executeUpdate("create_media_trigger.sql");
        executeUpdate("create_user_trigger.sql");

    }
}
