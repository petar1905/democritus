package github.petar1905.auxillary.classes;

import javax.swing.JTextField;

import github.petar1905.models.User;

public abstract class UserUpdateListener extends FieldListener {
    protected User user;

    public UserUpdateListener(User user, JTextField field) {
        super(field);
        this.user = user;
    }
    
}
