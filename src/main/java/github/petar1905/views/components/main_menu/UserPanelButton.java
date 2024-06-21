package github.petar1905.views.components.main_menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import github.petar1905.views.UserSearchView;

class UserPanelButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {        
        UserSearchView view = new UserSearchView();
        view.setVisible(true);
    }
}

public class UserPanelButton extends MainMenuButton {
    public UserPanelButton() {
        super();
        this.setText("Insert/Edit User");
        this.addActionListener(new UserPanelButtonListener());
    }
}
