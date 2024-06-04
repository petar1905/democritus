package github.petar1905.views.components.user_form_panel;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import github.petar1905.models.User;

public class UserForm extends JPanel {
    public UserForm(User user) {
        super();
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(new NameField(user));
        this.add(new GSMField(user));
        this.add(new EGNField(user));
        this.add(new AddressField(user));
        this.add(new DescriptionField(user));
    }
}
