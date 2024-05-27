package github.petar1905.services;

import java.io.IOException;
import java.sql.Connection;
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
    Rent[] getRents(User user);
    Rent[] getRents(Media media);
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
    public Rent[] getRents(User user) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getRents'");
    }

    @Override
    public Rent[] getRents(Media media) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getRenters'");
    }
}
