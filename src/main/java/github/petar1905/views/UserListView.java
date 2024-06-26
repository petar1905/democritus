package github.petar1905.views;

import java.io.IOException;
import java.sql.SQLException;
import github.petar1905.auxillary.classes.swing.ButtonContainer;
import github.petar1905.auxillary.classes.swing.EmptyPanel;
import github.petar1905.auxillary.classes.swing.View;
import github.petar1905.exceptions.UserException;
import github.petar1905.models.User;
import github.petar1905.views.components.user_list_panel.NewUserButton;
import github.petar1905.views.components.user_list_panel.ScrollableUserList;

public class UserListView extends View {
    public UserListView(User[] users) throws SQLException, IOException, UserException {
        super(
            EmptyPanel.getInstance().panel,
            new ScrollableUserList(users),
            new ButtonContainer(new NewUserButton())
        );
        this.setTitle("User List");
    }
}
