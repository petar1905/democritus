package github.petar1905.views.components.rent_form_panel;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.*;

import github.petar1905.auxillary.classes.swing.listeners.UserUpdateListener;
import github.petar1905.models.User;
import github.petar1905.views.SingleUserView;

class UserProfileListener extends UserUpdateListener {
    public UserProfileListener(User user) {
        super(user, null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        SingleUserView userProfile = new SingleUserView(getModel());
        userProfile.setVisible(true);
    }
}


class UserField extends JPanel {
    public UserField(User user) {
        super();
        this.add(new JLabel(String.format("User: %s", user.getName())));
        JButton userButton = new JButton("Open User Profile");
        userButton.addActionListener(new UserProfileListener(user));
    } 
}
