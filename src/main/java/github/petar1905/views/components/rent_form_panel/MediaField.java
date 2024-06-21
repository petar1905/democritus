package github.petar1905.views.components.rent_form_panel;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.*;
import github.petar1905.auxillary.classes.swing.listeners.MediaUpdateListener;
import github.petar1905.models.Media;
import github.petar1905.views.SingleMediaView;

class MediaProfileListener extends MediaUpdateListener {
    public MediaProfileListener(Media media) {
        super(media, null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        SingleMediaView mediaProfile = new SingleMediaView(getModel());
        mediaProfile.setVisible(true);
    }
}


class MediaField extends JPanel {
    public MediaField(Media media) {
        super();
        this.add(new JLabel(String.format("User: %s", media.getName())));
        JButton userButton = new JButton("Open Media Profile");
        userButton.addActionListener(new MediaProfileListener(media));
    } 
}
