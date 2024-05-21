package github.petar1905;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.sql.SQLException;

import org.junit.Test;
import github.petar1905.auxillary.classes.Database;
import github.petar1905.exceptions.UserException;
import github.petar1905.models.User;

/**
 * Unit test for simple App.
 */
public class UserTest 
{
    /**
     * Rigorous Test :-)
     * @throws SQLException 
     * @throws UserException 
     * @throws IOException 
     */
    @Test
    public void testDB() throws IOException, UserException
    {
        try {
            Database.getInstance().initializeDatabase();
            User user = new User();
            user.setName("TestUser");
            User user2 = new User(user.getId());;
            assertTrue(user.getId() == user2.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
