package github.petar1905.services;

import github.petar1905.models.User;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import github.petar1905.auxillary.classes.Database;
import github.petar1905.auxillary.classes.IO;
import github.petar1905.exceptions.UserException;

interface UserServiceMethods {
    User[] getAllUsers() throws SQLException, IOException, UserException;
    User[] searchByNameRegex(String regex) throws SQLException, IOException, UserException;
    int getAmountOfUsers() throws SQLException;
}

public class UserService implements UserServiceMethods {
    public User[] getAllUsers() throws SQLException, IOException, UserException {
        User[] users = new User[getAmountOfUsers()];
        String baseDirectory = "sql/queries/database_operations/users";
        String format = "%s/select_all_users.sql";
        String path = String.format(format, baseDirectory);
        String query = IO.getInstance().readFile(path);
        Connection con = Database.getInstance().connection;
        Statement statement = con.createStatement();
        ResultSet rs = statement.executeQuery(query);
        int selected_index = 0;
        while (rs.next()) {
            users[selected_index++] = new User(rs.getInt(1));
        }
        return users;
    }

    public User[] searchByNameRegex(String regex) throws SQLException, IOException, UserException {
        List<User> users = new ArrayList<>();
        String baseDirectory = "sql/queries/database_operations/users";
        String format = "%s/select_by_name.sql";
        String path = String.format(format, baseDirectory);
        String query = IO.getInstance().readFile(path);
        Connection con = Database.getInstance().connection;
        PreparedStatement statement = con.prepareStatement(query);
        statement.setString(1, regex);
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {
            users.add(new User(rs.getInt(1)));
        }
        User[] usersArray = new User[users.size()];
        return users.toArray(usersArray);
    }

    public int getAmountOfUsers() throws SQLException {
        Connection con = Database.getInstance().connection;
        String baseDirectory = "sql/queries/database_operations/users";
        String format = "%s/select_count.sql";
        String path = String.format(format, baseDirectory);
        Statement statement = con.createStatement();
        ResultSet rs = statement.executeQuery(path);
        int val = 0;
        while (rs.next()) {
            val = rs.getInt(1);
        }
        return val;
    }
    
}