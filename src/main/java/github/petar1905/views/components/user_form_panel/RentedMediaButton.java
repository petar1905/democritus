package github.petar1905.views.components.user_form_panel;

import javax.swing.JButton;

import github.petar1905.auxillary.classes.swing.listeners.UserUpdateListener;
import github.petar1905.exceptions.MediaException;
import github.petar1905.exceptions.RentException;
import github.petar1905.exceptions.UserException;
import github.petar1905.models.User;
import github.petar1905.services.RentService;
import github.petar1905.views.RentListView;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.sql.SQLException;

class RentedMediaListener extends UserUpdateListener {
    public RentedMediaListener(User user) {
        super(user, null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        RentListView view;
        try {
            view = new RentListView(RentService.getInstance().getRents(getModel()));
            view.setTitle(String.format("%s's rents", getModel().getName()));
            view.setVisible(true);
        } catch (SQLException | IOException | UserException | MediaException | RentException e1) {
            e1.printStackTrace();
        }
    }
}

public class RentedMediaButton extends JButton {
    public RentedMediaButton(User user) {
        super("View Rented Media");
        this.addActionListener(new RentedMediaListener(user));

    }
}
