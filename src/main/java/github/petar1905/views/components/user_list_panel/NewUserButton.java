package github.petar1905.views.components.user_list_panel;

import github.petar1905.exceptions.UserException;
import github.petar1905.models.User;
import github.petar1905.views.SingleUserView;
import github.petar1905.views.components.main_menu.MainMenuButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;



class NewUserButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
            User user;
            try {
                user = new User();
                SingleUserView settingsView = new SingleUserView(user);
                settingsView.setVisible(true);
            } catch (SQLException | UserException e1) {
                e1.printStackTrace();
            }

    }
}

public class NewUserButton extends MainMenuButton {
    public NewUserButton() {
        super();
        this.setText("New User");
        this.addActionListener(new NewUserButtonListener());
    }
}
