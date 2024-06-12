package github.petar1905.views.components.user_list_panel;

import java.awt.event.MouseEvent;
import github.petar1905.auxillary.classes.swing.ModelList;
import github.petar1905.auxillary.classes.swing.listeners.ModelListMouseListener;
import github.petar1905.models.User;
import github.petar1905.views.SingleUserView;

public class UserListMouseListener extends ModelListMouseListener<User> {
    public UserListMouseListener(ModelList<User> parent) {
        super(parent);
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getClickCount() == 2) {
            SingleUserView view = new SingleUserView(getParent().getSelectedValue());
            view.setVisible(true);
        }
    }
}
