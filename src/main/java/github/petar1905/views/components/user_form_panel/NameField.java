package github.petar1905.views.components.user_form_panel;

import java.awt.event.ActionEvent;
import java.sql.SQLException;
import javax.swing.JTextField;

import github.petar1905.auxillary.classes.Database;
import github.petar1905.auxillary.classes.swing.Field;
import github.petar1905.auxillary.classes.swing.listeners.UserUpdateListener;
import github.petar1905.exceptions.UserException;
import github.petar1905.models.User;

class NameUpdateListener extends UserUpdateListener {
    public NameUpdateListener(User user, JTextField field) {
        super(user, field);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            model.setName(field.getText());
            Database.getInstance().connection.commit();
        } catch (SQLException | UserException e1) {
            e1.printStackTrace();
        }
    } 
}

class NameField extends Field {
    public NameField(User user) {
        super("Name", user.getName(), true);
        this.setListener(new NameUpdateListener(user, getTextField()));
    }
}
