package github.petar1905;
import java.io.IOException;
import java.sql.SQLException;

import github.petar1905.auxillary.classes.swing.View;
import github.petar1905.exceptions.*;
import github.petar1905.views.*;
public class Democritus 
{
    public static void main( String[] args ) throws SQLException, IOException, MediaException, UserException
    {
        View view = new MainMenuView();
        view.setVisible(true);
    }
}
