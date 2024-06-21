package github.petar1905.views;

import javax.swing.JPanel;

import github.petar1905.auxillary.classes.swing.ButtonContainer;
import github.petar1905.auxillary.classes.swing.View;
import github.petar1905.models.User;
import github.petar1905.views.components.user_form_panel.DeleteUserButton;
import github.petar1905.views.components.user_form_panel.NewRentButton;
import github.petar1905.views.components.user_form_panel.RentedMediaButton;
import github.petar1905.views.components.user_form_panel.UserForm;


class RentOptions extends JPanel {
    public RentOptions(User user) {
        super();
        this.add(new RentedMediaButton(user));
        this.add(new NewRentButton(user));
    }
}

public class SingleUserView extends View {
    public SingleUserView(User user) {
        super(
            new RentOptions(user),
            new UserForm(user), 
            new ButtonContainer(new DeleteUserButton(user))
        );
        this.setTitle(String.format("User %s", user.getName()));
    }
}
