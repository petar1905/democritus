package github.petar1905.models;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import github.petar1905.auxillary.classes.Database;
import github.petar1905.auxillary.classes.IO;
import github.petar1905.exceptions.RentException;
import lombok.Getter;

public class Rent {
    private @Getter int id;
    private @Getter Media media;
    private @Getter User user;
    private @Getter Timestamp startDate;
    private @Getter Timestamp endDate;

    public Rent(int userId, int mediaId) {
        // TODO: Query database for extra info and throw exception if not found
    }

    public Rent(int userId, int mediaId, Timestamp startDate, Timestamp endDate) throws SQLException, IOException {
        String queryPath = "sql/queries/database_operations/rents/insert_rent.sql";
        String query = IO.getInstance().readFile(queryPath);
        Database db = Database.getInstance();
        PreparedStatement statement = db.connection.prepareStatement(query);
        statement.setInt(1, mediaId);
        statement.setInt(2, userId);
        statement.setTimestamp(3, startDate);
        statement.setTimestamp(4, endDate);
        statement.executeQuery();
    }

    public void delete() throws IOException, SQLException, RentException {
        String queryPath = "sql/queries/database_operations/rents/delete_rent.sql";
        String query = IO.getInstance().readFile(queryPath);
        Database db = Database.getInstance();
        PreparedStatement statement = db.connection.prepareStatement(query);
        statement.setInt(1, id);
        int result = statement.executeUpdate();
        if (result != 1) {
            String format = "Unknown error. Cannot delete ID %d";
            String msg = String.format(format, id);
            throw new RentException(msg);
        }
        // TODO: Make deleted instances unusable
    }
}
