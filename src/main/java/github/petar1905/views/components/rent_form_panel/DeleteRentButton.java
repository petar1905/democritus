package github.petar1905.views.components.rent_form_panel;

import github.petar1905.auxillary.classes.Database;
import github.petar1905.auxillary.classes.swing.listeners.RentUpdateListener;
import github.petar1905.exceptions.RentException;
import github.petar1905.models.Rent;
import github.petar1905.views.components.main_menu.MainMenuButton;
import java.awt.event.*;
import java.io.IOException;
import java.sql.SQLException;

class RentDeleteListener extends RentUpdateListener {
    public RentDeleteListener(Rent rent) {
        super(rent, null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {        
        try {
            this.getModel().delete();
            Database.getInstance().connection.commit();
        } catch (IOException | SQLException | RentException e1) {
            e1.printStackTrace();
        }
    }
}



public class DeleteRentButton extends MainMenuButton {
    public DeleteRentButton(Rent rent) {
        super();
        this.setText("Delete");
        this.addActionListener(new RentDeleteListener(rent));
    }
}
