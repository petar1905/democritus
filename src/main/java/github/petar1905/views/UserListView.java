package github.petar1905.views;

import java.io.IOException;
import java.sql.SQLException;
import javax.swing.JPanel;
import github.petar1905.auxillary.classes.View;
import github.petar1905.exceptions.UserException;
import github.petar1905.models.User;
import github.petar1905.views.components.user_list.ScrollableUserList;

public class UserListView extends View {
    public UserListView(User[] users) throws SQLException, IOException, UserException {
        super(new JPanel(), new ScrollableUserList(users), new JPanel());
    }
}
