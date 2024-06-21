package github.petar1905.views.components.media_form_panel;

import github.petar1905.auxillary.classes.Database;
import github.petar1905.auxillary.classes.swing.listeners.MediaUpdateListener;
import github.petar1905.exceptions.MediaException;
import github.petar1905.models.Media;
import github.petar1905.views.components.main_menu.MainMenuButton;
import java.awt.event.*;
import java.sql.SQLException;

class MediaDeleteListener extends MediaUpdateListener {
    private DeleteMediaButton button;

    public MediaDeleteListener(Media media, DeleteMediaButton button) {
        super(media, null);
        this.button = button;

    }

    @Override
    public void actionPerformed(ActionEvent e) {        
        try {
            String format = "%s has been deleted successfully";
            button.setText(String.format(format, this.getModel().getName()));
            this.getModel().delete();
            Database.getInstance().connection.commit();
        } catch (SQLException | MediaException e1) {
            e1.printStackTrace();
        }
    }
}



public class DeleteMediaButton extends MainMenuButton {
    public DeleteMediaButton(Media media) {
        super();
        this.setText("Delete");
        this.addActionListener(new MediaDeleteListener(media, this));
    }
}
