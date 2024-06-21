package github.petar1905.views;

import github.petar1905.auxillary.classes.swing.EmptyPanel;
import github.petar1905.auxillary.classes.swing.View;
import github.petar1905.views.components.user_search_panel.UserSearchForm;

public class UserSearchView extends View {
    public UserSearchView() {
        super(
            EmptyPanel.getInstance().panel,
            new UserSearchForm(),
            EmptyPanel.getInstance().panel
        );
        this.setTitle("User List Options");
    }
}
