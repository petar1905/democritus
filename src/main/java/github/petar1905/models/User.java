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

    public User(int id) throws SQLException, UserNotFoundException, IOException {
        String queryPath = "sql/queries/database_operations/users/select_user.sql";
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

    private void setStringInDB(String queryPath, String newValue) throws SQLException, IOException {
        String baseDirectory = "sql/queries/database_operations/users";
        queryPath = String.format("%s/%s", baseDirectory, queryPath);
        String query = IO.getInstance().readFile(queryPath);
        Database db = Database.getInstance();
        PreparedStatement statement = db.connection.prepareStatement(query);
        statement.setString(1, newValue);
        statement.setInt(2, id);
        statement.executeUpdate();
    }

    public void setName(String name) throws IOException, SQLException {
        String queryPath = "set_name.sql";
        this.setStringInDB(queryPath, name);
        this.name = name;
    }

    public void setEGNNumber(String egnNumber) throws IOException, SQLException {
        String queryPath = "set_egn_number.sql";
        this.setStringInDB(queryPath, egnNumber);
        this.egnNumber = egnNumber;
    }

    public void setGSMNumber(String gsmNumber) throws IOException, SQLException {
        String queryPath = "set_gsm_number.sql";
        this.setStringInDB(queryPath, gsmNumber);
        this.gsmNumber = gsmNumber;
    }

    public void setAddress(String address) throws IOException, SQLException {
        String queryPath = "set_address.sql";
        this.setStringInDB(queryPath, address);
        this.address = address;
    }

    public void setDescription(String description) throws IOException, SQLException {
        String queryPath = "set_description.sql";
        this.setStringInDB(queryPath, description);
        this.description = description;
    }

    public void delete() throws IOException, SQLException, UserException {
        String queryPath = "sql/queries/database_operations/users/delete_user.sql";
        String query = IO.getInstance().readFile(queryPath);
        Database db = Database.getInstance();
        PreparedStatement statement = db.connection.prepareStatement(query);
        statement.setInt(1, id);
        int result = statement.executeUpdate();
        if (result != 1) {
            String format = "Unknown error. Cannot delete ID %d";
            String msg = String.format(format, id);
            throw new UserException(msg);
        }
    }
}