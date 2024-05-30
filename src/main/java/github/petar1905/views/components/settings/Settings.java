package github.petar1905.views.components.settings;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class Settings extends JPanel {
    public Settings() {
        super();
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(new HostField());
        this.add(new UsernameField());
        this.add(new PasswordField());
    }   
}
