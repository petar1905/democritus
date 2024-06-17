package github.petar1905.views.components.main_menu;
import java.awt.event.*;
import java.sql.SQLException;

import github.petar1905.exceptions.MediaException;
import github.petar1905.models.Media;
import github.petar1905.services.MediaService;
import github.petar1905.views.MediaListView;

class MediaPanelButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        Media[] mediaArray;
        try {
            mediaArray = MediaService.getInstance().getAllMedia();
            MediaListView view = new MediaListView(mediaArray);
            view.setVisible(true);
        } catch (SQLException | MediaException e1) {
            e1.printStackTrace();
        }
    } 
}



public class MediaPanelButton extends MainMenuButton {
    public MediaPanelButton() {
        super();
        this.setText("Insert/Edit Media");
        this.addActionListener(new MediaPanelButtonListener());
    }
}
