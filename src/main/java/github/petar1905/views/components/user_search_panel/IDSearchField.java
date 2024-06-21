package github.petar1905.views.components.user_search_panel;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JTextField;

import github.petar1905.auxillary.classes.swing.Field;
import github.petar1905.auxillary.classes.swing.listeners.ModelSearchListener;
import github.petar1905.exceptions.UserException;
import github.petar1905.models.User;
import github.petar1905.views.SingleUserView;


class IDSearchListener extends ModelSearchListener<User> {

    public IDSearchListener(JTextField field) {
        super(null, field);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            User user = new User(Integer.parseInt(field.getText()));
            SingleUserView view = new SingleUserView(user);
            view.setVisible(true);
        } catch (SQLException | IOException | UserException e1) {
            e1.printStackTrace();
        }
    }
    
}


class IDSearchField extends Field {
    public IDSearchField() {
        super("Search by ID", "", true);
        this.setListener(new IDSearchListener(textField));
    }
    
}
