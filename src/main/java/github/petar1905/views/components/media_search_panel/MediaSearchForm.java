package github.petar1905.views.components.media_search_panel;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class MediaSearchForm extends JPanel {
    public MediaSearchForm() {
        super();
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(new NameSearchField());
        this.add(new IDSearchField());
        this.add(new AllMediaButton());
    }
}
