package github.petar1905.views.components.user_list_panel;

import github.petar1905.auxillary.classes.ScrollableModelList;
import github.petar1905.models.User;

public class ScrollableUserList extends ScrollableModelList<User> {
    public ScrollableUserList(User[] users) {
        super(users);
    }
}