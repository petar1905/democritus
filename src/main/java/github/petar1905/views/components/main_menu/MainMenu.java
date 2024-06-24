package github.petar1905.views.components.main_menu;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.*;

public class MainMenu extends JPanel {
    public MainMenu() throws SQLException, IOException {
        super();
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(new UserPanelButton());
        this.add(new MediaPanelButton());
        this.add(new RentPanelButton());
        this.add(new SettingsPanelButton());
    }
}