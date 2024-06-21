package github.petar1905.views.components.user_search_panel;
import javax.swing.JButton;

import github.petar1905.exceptions.UserException;
import github.petar1905.models.User;
import github.petar1905.services.UserService;
import github.petar1905.views.UserListView;

import java.awt.event.*;
import java.io.IOException;
import java.sql.SQLException;

class AllUsersListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            User[] users = UserService.getInstance().getAllUsers();
            UserListView view = new UserListView(users);
            view.setVisible(true);
        } catch (SQLException | IOException | UserException e1) {
            e1.printStackTrace();
        }

    }
}

class AllUsersButton extends JButton {
    public AllUsersButton() {
        super("All Users");
        this.addActionListener(new AllUsersListener());
    }
}
