package github.petar1905.views.components.user_search_panel;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class UserSearchForm extends JPanel {
    public UserSearchForm() {
        super();
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(new NameSearchField());
        this.add(new IDSearchField());
        this.add(new AllUsersButton());
    }
}
