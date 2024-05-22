package github.petar1905;

import static org.junit.Assert.assertNotNull;
import java.io.IOException;
import github.petar1905.auxillary.classes.IO;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class IOTest 
{
    /**
     * Rigorous Test :-)
     * @throws IOException 
     */
    @Test
    public void ioTest() throws IOException
    {
        String query = IO.getInstance().readFile("sql/queries/database_init/create_rent_decrement_trigger.sql");
        assertNotNull(query);
    }
}
