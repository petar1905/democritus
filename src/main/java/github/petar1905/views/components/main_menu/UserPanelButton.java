package github.petar1905.views.components.main_menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

import github.petar1905.exceptions.UserException;
import github.petar1905.models.User;
import github.petar1905.services.UserService;
import github.petar1905.views.UserListView;

class UserPanelButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {        
        try {
            User[] users = UserService.getInstance().getAllUsers();
            UserListView userListView = new UserListView(users);
            userListView.setVisible(true);
        } catch (SQLException | IOException | UserException e1) {
            e1.printStackTrace();
        }
    }
}

public class UserPanelButton extends MainMenuButton {
    public UserPanelButton() {
        super();
        this.setText("Insert/Edit User");
        this.addActionListener(new UserPanelButtonListener());
    }
}
