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
import github.petar1905.models.Media;

interface MediaServiceMethods {
    Media[] getAllMedia() throws SQLException, IOException, MediaException;
    Media[] searchByNameRegex(String regex) throws SQLException, IOException, MediaException;
    Media[] searchByAuthorRegex(String regex) throws SQLException, IOException, MediaException;
    int getAmountOfMedia() throws SQLException;
}

public class MediaService implements MediaServiceMethods {
    private static MediaService singleInstance = null;

    private MediaService() {}

    public static synchronized MediaService getInstance() {
        if (singleInstance == null) {
            singleInstance = new MediaService();
        }
        return singleInstance;
    }

    public Media[] getAllMedia() throws SQLException, MediaException {
        List<Media> media = new ArrayList<>();
        String baseDirectory = "sql/queries/database_operations/media";
        String format = "%s/select_all_media.sql";
        String path = String.format(format, baseDirectory);
        String query = IO.getInstance().readFile(path);
        Connection con = Database.getInstance().connection;
        PreparedStatement statement = con.prepareStatement(query);
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
            media.add(new Media(rs.getInt(1)));
        }
        Media[] mediaArray = new Media[media.size()];
        return media.toArray(mediaArray);
    }

    public Media[] searchByNameRegex(String regex) throws SQLException, IOException, MediaException {
        List<Media> media = new ArrayList<>();
        String baseDirectory = "sql/queries/database_operations/media";
        String format = "%s/select_by_name.sql";
        String path = String.format(format, baseDirectory);
        String query = IO.getInstance().readFile(path);
        Connection con = Database.getInstance().connection;
        PreparedStatement statement = con.prepareStatement(query);
        statement.setString(1, regex);
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {
            media.add(new Media(rs.getInt(1)));
        }
        Media[] mediaArray = new Media[media.size()];
        return media.toArray(mediaArray);
    }

    public Media[] searchByAuthorRegex(String regex) throws SQLException, IOException, MediaException {
        List<Media> media = new ArrayList<>();
        String baseDirectory = "sql/queries/database_operations/media";
        String format = "%s/select_by_author.sql";
        String path = String.format(format, baseDirectory);
        String query = IO.getInstance().readFile(path);
        Connection con = Database.getInstance().connection;
        PreparedStatement statement = con.prepareStatement(query);
        statement.setString(1, regex);
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {
            media.add(new Media(rs.getInt(1)));
        }
        Media[] mediaArray = new Media[media.size()];
        return media.toArray(mediaArray);
    }

    public int getAmountOfMedia() throws SQLException {
        Connection con = Database.getInstance().connection;
        String baseDirectory = "sql/queries/database_operations/media";
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
