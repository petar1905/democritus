package github.petar1905.views.components.main_menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

import github.petar1905.auxillary.classes.Database;
import github.petar1905.exceptions.MediaException;
import github.petar1905.exceptions.RentException;
import github.petar1905.exceptions.UserException;
import github.petar1905.models.Rent;
import github.petar1905.services.RentService;
import github.petar1905.views.RentListView;


class RentPanelButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        Rent[] rentArray;
        try {
            Database.getInstance().initializeDatabase();
            rentArray = RentService.getInstance().getAllRents();
            RentListView view = new RentListView(rentArray);
            view.setVisible(true);
        } catch (SQLException | RentException | IOException | UserException | MediaException e1) {
            e1.printStackTrace();
        }
    } 
}

public class RentPanelButton extends MainMenuButton {
    public RentPanelButton() throws SQLException, IOException {
        super();
        this.setText("View All Rents");
        this.addActionListener(new RentPanelButtonListener());
    }
}
