package github.petar1905.views.components.media_form_panel;

import github.petar1905.auxillary.classes.swing.listeners.MediaUpdateListener;
import github.petar1905.exceptions.MediaException;
import github.petar1905.models.Media;
import github.petar1905.views.components.main_menu.MainMenuButton;
import java.awt.event.*;
import java.sql.SQLException;

class MediaDeleteListener extends MediaUpdateListener {
    public MediaDeleteListener(Media media) {
        super(media, null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {        
        try {
            this.getModel().delete();

        } catch (SQLException | MediaException e1) {
            e1.printStackTrace();
        }
    }
}



public class DeleteMediaButton extends MainMenuButton {
    public DeleteMediaButton(Media media) {
        super();
        this.setText("Delete");
        this.addActionListener(new MediaDeleteListener(media));
    }
}
