package github.petar1905.views.components.user_form_panel;

import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.sql.SQLException;
import github.petar1905.auxillary.classes.Field;
import github.petar1905.auxillary.classes.UserUpdateListener;
import github.petar1905.exceptions.UserException;
import github.petar1905.models.User;


class GSMUpdateListener extends UserUpdateListener {
    public GSMUpdateListener(User user, JTextField field) {
        super(user, field);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            user.setGSMNumber(field.getText());
        } catch (IOException | SQLException | UserException e1) {
            e1.printStackTrace();
        }
    } 
}
class GSMField extends Field {
    public GSMField (User user) {
        super("GSM", user.getGsmNumber());
        this.setListener(new GSMUpdateListener(user, getTextField()));
    }
}
