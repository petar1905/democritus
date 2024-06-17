package github.petar1905.views.components.user_form_panel;

import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

import github.petar1905.auxillary.classes.swing.Field;
import github.petar1905.auxillary.classes.swing.listeners.UserUpdateListener;
import github.petar1905.exceptions.UserException;
import github.petar1905.models.User;


class EGNUpdateListener extends UserUpdateListener {
    public EGNUpdateListener(User user, JTextField field) {
        super(user, field);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            model.setEGNNumber(field.getText());
        } catch (SQLException | UserException e1) {
            e1.printStackTrace();
        }
    } 
}
class EGNField extends Field {
    public EGNField(User user) {
        super("EGN", user.getEgnNumber());
        this.setListener(new EGNUpdateListener(user, getTextField()));
    }
}
