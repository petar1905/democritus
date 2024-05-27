package github.petar1905.services;

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
import github.petar1905.exceptions.MediaException;
import github.petar1905.exceptions.RentException;
import github.petar1905.exceptions.UserException;
import github.petar1905.models.Media;
import github.petar1905.models.Rent;
import github.petar1905.models.User;

interface RentServiceMethods {
    Rent[] getAllRents() throws IOException, SQLException, MediaException, RentException, UserException;
    Rent[] getRents(User user) throws IOException, SQLException, MediaException, RentException, UserException;
    Rent[] getRents(Media media) throws IOException, SQLException, MediaException, RentException, UserException;
}

public class RentService implements RentServiceMethods {
    private static RentService singleInstance = null;

    private RentService() {}

    public static synchronized RentService getInstance() {
        if (singleInstance == null) {
            singleInstance = new RentService();
        }
        return singleInstance;
    }

    @Override
    public Rent[] getAllRents() throws IOException, SQLException, MediaException, RentException, UserException {
        String queryPath = "sql/queries/database_operations/rents/select_all_rents.sql";
        String query = IO.getInstance().readFile(queryPath);
        Connection con = Database.getInstance().connection;
        Statement statement = con.createStatement();
        ResultSet rs = statement.executeQuery(query);
        List<Rent> rentList = new ArrayList<>();
        Rent rent;
        while (rs.next()) {
            rent = new Rent(rs.getInt(1));
            rentList.add(rent);
        }
        Rent[] rentArray = new Rent[rentList.size()];
        return rentList.toArray(rentArray);
    }

    @Override
    public Rent[] getRents(User user) throws IOException, SQLException, MediaException, RentException, UserException {
        String queryPath = "sql/queries/database_operations/rents/select_rents_of_user.sql";
        String query = IO.getInstance().readFile(queryPath);
        Connection con = Database.getInstance().connection;
        PreparedStatement statement = con.prepareStatement(query);
        statement.setInt(1, user.getId());
        ResultSet rs = statement.executeQuery();
        List<Rent> rentList = new ArrayList<>();
        Rent rent;
        while (rs.next()) {
            rent = new Rent(rs.getInt(1));
            rentList.add(rent);
        }
        Rent[] rentArray = new Rent[rentList.size()];
        return rentList.toArray(rentArray);
    }

    @Override
    public Rent[] getRents(Media media) throws IOException, SQLException, MediaException, RentException, UserException {
        String queryPath = "sql/queries/database_operations/rents/select_rents_of_media.sql";
        String query = IO.getInstance().readFile(queryPath);
        Connection con = Database.getInstance().connection;
        PreparedStatement statement = con.prepareStatement(query);
        statement.setInt(1, media.getId());
        ResultSet rs = statement.executeQuery();
        List<Rent> rentList = new ArrayList<>();
        Rent rent;
        while (rs.next()) {
            rent = new Rent(rs.getInt(1));
            rentList.add(rent);
        }
        Rent[] rentArray = new Rent[rentList.size()];
        return rentList.toArray(rentArray);
    }
}

// TODO Handle situations in which a user rents the same media several times.