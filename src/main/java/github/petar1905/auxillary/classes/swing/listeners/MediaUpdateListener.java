package github.petar1905.auxillary.classes.swing.listeners;

import javax.swing.JTextField;
import github.petar1905.models.Media;

public abstract class MediaUpdateListener extends ModelUpdateListener<Media> {
    public MediaUpdateListener(Media media, JTextField field) {
        super(media, field);
    }
    
}
