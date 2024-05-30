package github.petar1905.views.components.main_menu;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.border.Border;

public abstract class MainMenuButton extends JButton {
    public MainMenuButton() {
        super();
        this.setAlignmentX(JButton.CENTER_ALIGNMENT);
        int padding = 10;
        Border compoundBorder = BorderFactory.createCompoundBorder(
            this.getBorder(),
            BorderFactory.createEmptyBorder(padding, padding, padding, padding)
        );
        this.setBorder(compoundBorder);
    }
}
