package github.petar1905.views.components.media_form_panel;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.sql.SQLException;
import javax.swing.JTextField;
import github.petar1905.auxillary.classes.swing.Field;
import github.petar1905.auxillary.classes.swing.listeners.MediaUpdateListener;
import github.petar1905.exceptions.MediaException;
import github.petar1905.models.Media;

class QuantityUpdateListener extends MediaUpdateListener {
    public QuantityUpdateListener(Media media, JTextField field) {
        super(media, field);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            model.setQuantity(Integer.parseInt(field.getText()));
        } catch (IOException | SQLException | MediaException e1) {
            e1.printStackTrace();
        }
    } 
}

class QuantityField extends Field {
    public QuantityField(Media media) {
        super("Quantity", Integer.toString(media.getQuantity()));
        this.setListener(new QuantityUpdateListener(media, getTextField()));
    }
}
