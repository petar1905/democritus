package github.petar1905.views.components.user_form_panel;

import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.sql.SQLException;
import github.petar1905.auxillary.classes.Field;
import github.petar1905.auxillary.classes.UserUpdateListener;
import github.petar1905.exceptions.UserException;
import github.petar1905.models.User;


class AddressUpdateListener extends UserUpdateListener {
    public AddressUpdateListener(User user, JTextField field) {
        super(user, field);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            user.setAddress(field.getText());
        } catch (IOException | SQLException | UserException e1) {
            e1.printStackTrace();
        }
    } 
}
public class AddressField extends Field {
    public AddressField(User user) {
        super("Address", user.getAddress());
        this.setListener(new AddressUpdateListener(user, getTextField()));
    }
}