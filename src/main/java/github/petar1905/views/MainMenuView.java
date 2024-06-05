package github.petar1905.views;
import github.petar1905.auxillary.classes.swing.EmptyPanel;
import github.petar1905.auxillary.classes.swing.View;
import github.petar1905.views.components.main_menu.MainMenu;

public class MainMenuView extends View {
    public MainMenuView() {
        super(EmptyPanel.getInstance().panel, new MainMenu(), EmptyPanel.getInstance().panel);
        this.setTitle("Main Menu");
    }
}
