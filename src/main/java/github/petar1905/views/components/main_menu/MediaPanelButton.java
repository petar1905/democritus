package github.petar1905.views.components.main_menu;
import java.awt.event.*;
import github.petar1905.views.MediaSearchView;

class MediaPanelButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        MediaSearchView view = new MediaSearchView();
        view.setVisible(true);
    } 
}



public class MediaPanelButton extends MainMenuButton {
    public MediaPanelButton() {
        super();
        this.setText("Insert/Edit Media");
        this.addActionListener(new MediaPanelButtonListener());
    }
}
