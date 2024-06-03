package github.petar1905.views;
import github.petar1905.auxillary.classes.EmptyPanel;
import github.petar1905.auxillary.classes.View;
import github.petar1905.views.components.settings.Settings;

public class SettingsView extends View {
    public SettingsView() {
        super(EmptyPanel.getInstance().panel, new Settings(), EmptyPanel.getInstance().panel);
        this.setTitle("Settings");
    }
}