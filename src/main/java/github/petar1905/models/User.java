package github.petar1905.models;
import lombok.Getter;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import github.petar1905.auxillary.classes.Database;
import github.petar1905.auxillary.classes.IO;
import github.petar1905.exceptions.UserNotFoundException;

public class User {
    private @Getter int id;
    private @Getter String name;
    private @Getter String egnNumber;
    private @Getter String gsmNumber;
    private @Getter String address;
    private @Getter String description;
    // TODO: Setters that also change value in database.

    public User(int id) throws SQLException, UserNotFoundException, IOException {
        String queryPath = "sql/queries/database_operations/select_user.sql";
        String query = IO.getInstance().readFile(queryPath);
        Database db = Database.getInstance();
        PreparedStatement statement = db.connection.prepareStatement(query);
        statement.setInt(1, id);
        ResultSet result = statement.executeQuery();
        if (!result.next()) {
            String format = "User ID %d not found.";
            String msg = String.format(format, id);
            throw new UserNotFoundException(msg);
        } else {
            this.id = id;
            this.name = result.getString(1);
            this.egnNumber = result.getString(2);
            this.gsmNumber = result.getString(3);
            this.address = result.getString(4);
            this.description = result.getString(5);
        }
    }
}