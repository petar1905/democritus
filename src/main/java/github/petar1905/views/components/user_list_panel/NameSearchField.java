package github.petar1905.views.components.user_list_panel;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JTextField;

import github.petar1905.auxillary.classes.swing.Field;
import github.petar1905.auxillary.classes.swing.listeners.ModelSearchListener;
import github.petar1905.exceptions.UserException;
import github.petar1905.models.User;
import github.petar1905.services.UserService;


class UserNameSearchListener extends ModelSearchListener<User> {
    private User[] users;

    public UserNameSearchListener(User[] models, JTextField field) {
        super(models, field);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            users = UserService.getInstance().searchByNameRegex(field.getText());
        } catch (SQLException | IOException | UserException e1) {
            e1.printStackTrace();
        }
    }
    
}


public class NameSearchField extends Field {
    public NameSearchField(User[] users) {
        super("Search by name", "");
        this.setListener(new UserNameSearchListener(users, textField));
    }
    
}
