package github.petar1905.views;

import javax.swing.JPanel;

import github.petar1905.auxillary.classes.View;
import github.petar1905.views.components.settings.Settings;

public class SettingsView extends View {
    public SettingsView() {
        super(new JPanel(), new Settings(), new JPanel());
        this.setTitle("Settings");
    }
    
}
