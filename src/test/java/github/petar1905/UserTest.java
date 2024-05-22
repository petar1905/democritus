package github.petar1905;

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
    public void testUsers () throws IOException, UserException, SQLException
    {
        Database.getInstance().initializeDatabase();
        User user = new User();
        user.setName("hey");
        user.setDescription("hi hru");
        user.setEGNNumber("12345");
        user.setGSMNumber("0123456789");
        user.setAddress("perusha 4");
        User user2 = new User(user.getId());

        boolean descriptionsMatch = user.getDescription().equals(user2.getDescription());
        boolean namesMatch = user.getName().equals(user2.getName());
        boolean egnNumbersMatch = user.getEgnNumber().equals(user2.getEgnNumber());
        boolean gsmNumbersMatch = user.getGsmNumber().equals(user2.getGsmNumber());
        boolean addressesMatch = user.getAddress().equals(user2.getAddress());
        boolean everythingMatch = (descriptionsMatch && namesMatch && egnNumbersMatch && gsmNumbersMatch && addressesMatch); 
        assertTrue(everythingMatch);
    }
}
