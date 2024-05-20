package github.petar1905.auxillary.interfaces;

import java.io.IOException;
import java.sql.SQLException;

import github.petar1905.exceptions.MediaException;
import github.petar1905.exceptions.RentException;
import github.petar1905.exceptions.UserException;

public interface Deletable {
    void delete() throws IOException, SQLException, MediaException, UserException, RentException;
}
