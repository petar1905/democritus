package github.petar1905.views.components.main_menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import github.petar1905.views.SettingsView;

class SettingsPanelButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {        
        SettingsView settingsView = new SettingsView();
    settingsView.setVisible(true);
    }
}

public class SettingsPanelButton extends MainMenuButton {
    public SettingsPanelButton() {
        super();
        this.setText("Settings");
        this.addActionListener(new SettingsPanelButtonListener());
    }
}
