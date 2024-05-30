package github.petar1905.views;

import javax.swing.JPanel;

import github.petar1905.auxillary.classes.View;
import github.petar1905.views.components.main_menu.MainMenu;

public class MainMenuView extends View {
    public MainMenuView() {
        super(new JPanel(), new MainMenu(), new JPanel());
        this.setTitle("Main Menu");
    }
    
}
