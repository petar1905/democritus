package github.petar1905.views.components.main_menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

import github.petar1905.auxillary.classes.Database;
import github.petar1905.views.UserSearchView;

class UserPanelButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {    
        try {
            Database.getInstance().initializeDatabase();
        } catch (SQLException | IOException e1) {
            e1.printStackTrace();
        }    
        UserSearchView view = new UserSearchView();
        view.setVisible(true);
    }
}

public class UserPanelButton extends MainMenuButton {
    public UserPanelButton() throws SQLException, IOException {
        super();
        this.setText("Insert/Edit User");
        this.addActionListener(new UserPanelButtonListener());
    }
}
