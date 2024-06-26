package github.petar1905.views.components.user_form_panel;

import github.petar1905.auxillary.classes.Database;
import github.petar1905.auxillary.classes.swing.listeners.UserUpdateListener;
import github.petar1905.exceptions.UserException;
import github.petar1905.models.User;
import github.petar1905.views.components.main_menu.MainMenuButton;
import java.awt.event.*;
import java.sql.SQLException;

class UserDeleteListener extends UserUpdateListener {
    private DeleteUserButton button;
    public UserDeleteListener(User user, DeleteUserButton button) {
        super(user, null);
        this.button = button;
    }

    @Override
    public void actionPerformed(ActionEvent e) {        
        try {
            String format = "%s has been deleted successfully";
            button.setText(String.format(format, this.getModel().getName()));
            this.getModel().delete();
            Database.getInstance().connection.commit();
        } catch (SQLException | UserException e1) {
            e1.printStackTrace();
        }
    }
}

public class DeleteUserButton extends MainMenuButton {
    public DeleteUserButton(User user) {
        super();
        this.setText("Delete");
        this.addActionListener(new UserDeleteListener(user, this));

    }
}
