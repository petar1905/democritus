package github.petar1905.views;

import github.petar1905.auxillary.classes.EmptyPanel;
import github.petar1905.auxillary.classes.swing.View;
import github.petar1905.models.User;
import github.petar1905.views.components.user_form_panel.UserForm;

public class SingleUserView extends View {
    public SingleUserView(User user) {
        super(EmptyPanel.getInstance().panel, new UserForm(user), EmptyPanel.getInstance().panel);
        this.setTitle(String.format("User %s", user.getName()));
    }
}
