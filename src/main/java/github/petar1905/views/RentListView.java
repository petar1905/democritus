package github.petar1905.views;

import java.io.IOException;
import java.sql.SQLException;

import github.petar1905.auxillary.classes.swing.EmptyPanel;
import github.petar1905.auxillary.classes.swing.View;
import github.petar1905.exceptions.UserException;
import github.petar1905.models.Rent;
import github.petar1905.views.components.rent_list_panel.ScrollableRentList;

public class RentListView extends View {
    public RentListView(Rent[] rents) throws SQLException, IOException, UserException {
        super(
            EmptyPanel.getInstance().panel,
            new ScrollableRentList(rents),
            EmptyPanel.getInstance().panel
        );
        this.setTitle("Rent List");
    }
}
