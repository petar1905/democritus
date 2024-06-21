package github.petar1905.views.components.user_form_panel;

import java.awt.event.ActionEvent;
import java.sql.SQLException;

import javax.swing.JButton;

import github.petar1905.auxillary.classes.swing.EmptyPanel;
import github.petar1905.auxillary.classes.swing.View;
import github.petar1905.auxillary.classes.swing.listeners.UserUpdateListener;
import github.petar1905.exceptions.MediaException;
import github.petar1905.models.User;
import github.petar1905.services.MediaService;
import github.petar1905.views.components.new_rent_panel.NewRentForm;

class NewRentListener extends UserUpdateListener {
    public NewRentListener(User user) {
        super(user, null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            View view = new View(
                EmptyPanel.getInstance().panel,
                new NewRentForm(model, MediaService.getInstance().getAvailableMedia()),
                EmptyPanel.getInstance().panel
            );
            view.setTitle(String.format("Rent media as %s", getModel().getName()));
            view.setVisible(true);
        } catch (SQLException | MediaException e1) {
            e1.printStackTrace();
        }
    }
}

public class NewRentButton extends JButton {
    public NewRentButton(User user) {
        super("Rent Media");
        this.addActionListener(new NewRentListener(user));
    }
}
