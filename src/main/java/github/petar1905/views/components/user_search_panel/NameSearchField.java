package github.petar1905.views.components.user_search_panel;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JTextField;

import github.petar1905.auxillary.classes.swing.Field;
import github.petar1905.auxillary.classes.swing.listeners.ModelSearchListener;
import github.petar1905.exceptions.UserException;
import github.petar1905.models.User;
import github.petar1905.services.UserService;
import github.petar1905.views.UserListView;


class UserNameSearchListener extends ModelSearchListener<User> {

    public UserNameSearchListener(JTextField field) {
        super(null, field);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            User[] users = UserService.getInstance().searchByNameRegex(field.getText());
            UserListView view = new UserListView(users);
            view.setVisible(true);
        } catch (SQLException | IOException | UserException e1) {
            e1.printStackTrace();
        }
    }
    
}


class NameSearchField extends Field {
    public NameSearchField() {
        super("Search by name", "", true);
        this.setListener(new UserNameSearchListener(textField));
    }
    
}
