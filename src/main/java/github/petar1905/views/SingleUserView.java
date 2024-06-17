package github.petar1905.views;

import github.petar1905.auxillary.classes.swing.ButtonContainer;
import github.petar1905.auxillary.classes.swing.EmptyPanel;
import github.petar1905.auxillary.classes.swing.View;
import github.petar1905.models.User;
import github.petar1905.views.components.user_form_panel.DeleteUserButton;
import github.petar1905.views.components.user_form_panel.UserForm;

public class SingleUserView extends View {
    public SingleUserView(User user) {
        super(
            EmptyPanel.getInstance().panel, 
            new UserForm(user), 
            new ButtonContainer(new DeleteUserButton(user))
        );
        this.setTitle(String.format("User %s", user.getName()));
    }
}
