package github.petar1905.views.components.user_form_panel;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import github.petar1905.models.User;

public class UserForm extends JPanel {
    public UserForm(User user) {
        super();
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        NameField nameField = new NameField(user);
        this.add(nameField);
        GSMField gsmField = new GSMField(user);
        this.add(gsmField);
        EGNField egnField = new EGNField(user);
        this.add(egnField);
        AddressField addressField = new AddressField(user);
        this.add(addressField);
        DescriptionField descriptionField = new DescriptionField(user);
        this.add(descriptionField);

        

    }
}
