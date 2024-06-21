package github.petar1905.views.components.media_form_panel;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JButton;
import github.petar1905.auxillary.classes.swing.listeners.MediaUpdateListener;
import github.petar1905.exceptions.MediaException;
import github.petar1905.exceptions.RentException;
import github.petar1905.exceptions.UserException;
import github.petar1905.models.Media;
import github.petar1905.services.RentService;
import github.petar1905.views.RentListView;

class RentersListener extends MediaUpdateListener {
    public RentersListener(Media media) {
        super(media, null);
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        try {
            RentListView view = new RentListView(RentService.getInstance().getRents(getModel()));
            view.setTitle(String.format("Renters of %s", getModel().getName()));
            view.setVisible(true);
        } catch (SQLException | IOException | UserException | MediaException | RentException e) {
            e.printStackTrace();
        }
    }
}

public class RentersButton extends JButton {
    public RentersButton(Media media) {
        super("View Renters");
        this.addActionListener(new RentersListener(media));
    }
}
