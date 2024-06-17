package github.petar1905.views.components.media_list_panel;

import java.awt.event.MouseEvent;
import github.petar1905.auxillary.classes.swing.ModelList;
import github.petar1905.auxillary.classes.swing.listeners.ModelListMouseListener;
import github.petar1905.models.Media;
import github.petar1905.views.SingleMediaView;

public class MediaListMouseListener extends ModelListMouseListener<Media> {
    public MediaListMouseListener(ModelList<Media> parent) {
        super(parent);
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getClickCount() == 2) {
            SingleMediaView view = new SingleMediaView(getParent().getSelectedValue());
            view.setVisible(true);
        }
    }
}
