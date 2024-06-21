package github.petar1905.views.components.main_menu;
import javax.swing.*;

public class MainMenu extends JPanel {
    public MainMenu() {
        super();
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(new UserPanelButton());
        this.add(new MediaPanelButton());
        this.add(new RentPanelButton());
        this.add(new SettingsPanelButton());
    }
}